package tick.taku.android.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Document
import org.xml.sax.InputSource
import org.xml.sax.SAXException
import tick.taku.android.R
import java.io.StringReader
import java.io.StringWriter
import java.net.Socket
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathExpression
import javax.xml.xpath.XPathExpressionException
import javax.xml.xpath.XPathFactory


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BAD: Have both JavaScript and cross-origin resource access enabled in webview while
        // taking remote user inputs
        val wv = findViewById<View>(R.id.web_view) as WebView
        val webSettings = wv.settings

        webSettings.javaScriptEnabled = true
        webSettings.allowUniversalAccessFromFileURLs = true

        wv.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }

        val thisUrl =
            intent.extras!!.getString("url") // dangerous remote input from  the intent's Bundle of extras

        wv.loadUrl(thisUrl!!)

        val forwardIntent = intent.getParcelableExtra<Parcelable>("forward_intent") as Intent?
        startActivity(forwardIntent)

        val xmlStr = "<users>" +
                "   <user name=\"aaa\" pass=\"pass1\"></user>" +
                "   <user name=\"bbb\" pass=\"pass2\"></user>" +
                "</users>"
        try {
            val domFactory = DocumentBuilderFactory.newInstance()
            domFactory.isNamespaceAware = true
            val builder = domFactory.newDocumentBuilder()
            //Document doc = builder.parse("user.xml");
            val doc: Document = builder.parse(InputSource(StringReader(xmlStr)))
            val factory = XPathFactory.newInstance()
            val xpath: XPath = factory.newXPath()

            // Injectable data
            val user: String = ""
            val pass: String = ""
            if (user != null && pass != null) {
                var isExist = false

                // Bad expression
                val expression1 = "/users/user[@name='$user' and @pass='$pass']"
                isExist = xpath.evaluate(expression1, doc, XPathConstants.BOOLEAN) as Boolean
                println(isExist)

                // Bad expression
                val expression2: XPathExpression =
                    xpath.compile("/users/user[@name='$user' and @pass='$pass']")
                isExist = expression2.evaluate(doc, XPathConstants.BOOLEAN) as Boolean
                println(isExist)

                // Bad expression
                val sb = StringBuffer("/users/user[@name=")
                sb.append(user)
                sb.append("' and @pass='")
                sb.append(pass)
                sb.append("']")
                val query = sb.toString()
                val expression3: XPathExpression = xpath.compile(query)
                isExist = expression3.evaluate(doc, XPathConstants.BOOLEAN) as Boolean
                println(isExist)
            }
        } catch (e: ParserConfigurationException) {
        } catch (e: SAXException) {
        } catch (e: XPathExpressionException) {
        }
    }

    @Throws(Exception::class)
    fun transform(socket: Socket, inputXml: String?) {
        val xslt = StreamSource(socket.getInputStream())
        val xml = StreamSource(StringReader(inputXml))
        val result = StringWriter()
        val factory = TransformerFactory.newInstance()

        // BAD: User provided XSLT stylesheet is processed
        factory.newTransformer(xslt).transform(xml, StreamResult(result))
    }
}