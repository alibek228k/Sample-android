package kz.alibek.testinstagram

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val instagramButton: Button by lazy { findViewById(R.id.instagramButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        instagramButton.setOnClickListener {
            startActivity(InstagramActivity.newIntent(this))
        }
    }
}