package tick.taku.android.ui

import android.content.Intent
import android.net.Uri

class CodeQLTest {

    fun test() {
        val i = Intent()
        i.setClassName("org.wordpress.android.prealpha", "org.wordpress.android.ui.posts.EditPostActivity")
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

        Uri.parse("content://org.nextcloud/file")

        val secretKey = "absfggkjsjhaduiw::"
    }
}