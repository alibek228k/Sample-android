package kz.alibek.testinstagram

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InstagramActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, InstagramActivity::class.java)
    }

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }

    private val recyclerViewData = listOf(
        InstaData(
            title = "Arsenal FC",
            R.drawable.ic_arsenal,
        ),
        InstaData(
            title = "Arsenal FC home kit",
            R.drawable.ic_arsenal_kit,
        ),
        InstaData(
            title = "Bukayo Saka",
            R.drawable.ic_saka,
        ),
        InstaData(
            title = "Gabriel Jesus",
            R.drawable.ic_gaby_jesus,
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_instagram)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = InstaRecyclerAdapter(recyclerViewData)
    }
}