package kz.alibek.testinstagram

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kz.alibek.testinstagram.core.ui.TabManager

class InstagramActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    companion object {
        fun newIntent(context: Context) = Intent(context, InstagramActivity::class.java)
    }

    private val tabManager: TabManager by lazy { TabManager(this) }
    private val bottomNavigationView: BottomNavigationView by lazy {
        findViewById(R.id.bottomNavigationView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_instagram)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            tabManager.setInitialNavController()
        }
        setupBottomView()
        handleBottomTabVisibility()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        tabManager.switchTab(item.itemId)
        return true
    }

    private fun setupBottomView() {
        bottomNavigationView.setOnItemSelectedListener(this)
    }

    private fun handleBottomTabVisibility() {
        tabManager.isBottomTabVisible
            .onEach { isVisible ->
                bottomNavigationView.isVisible = isVisible
            }
            .launchIn(lifecycleScope)
    }
}