package tick.taku.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import dagger.hilt.android.AndroidEntryPoint
import tick.taku.android.feature.cat.compose.CatsScreen

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CatsScreen()
            }
        }
    }
}