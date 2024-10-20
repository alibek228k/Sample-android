package kz.alibek.testinstagram.core.ui

import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kz.alibek.testinstagram.InstagramActivity
import kz.alibek.testinstagram.tabbar.model.TabBarItem

class TabManager(
    private val instaActivity: InstagramActivity,
) {

    private val _isBottomTabVisible = MutableStateFlow(false)
    val isBottomTabVisible: StateFlow<Boolean> = _isBottomTabVisible

    private var currentController: NavController? = null
    private val currentDestinationId get() = currentController?.currentDestination?.id
    private val tabNavControllerMap by lazy(LazyThreadSafetyMode.NONE) {
        TabBarItem.entries.associateWith { LazyNavController(it) }
    }

    private val tabContainerViewMap = TabBarItem.entries
        .associateWith { instaActivity.findViewById<View>(it.containerId) }

    private val onDestinationChangedListener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            _isBottomTabVisible.update {
                isTabNavDestinationId(destination.id)
            }
        }

    fun switchTab(tabId: Int) {
        val tab = TabBarItem.entries.find { it.tabId == tabId } ?: return
        currentController?.removeOnDestinationChangedListener(onDestinationChangedListener)
        tabContainerViewMap.forEach { (_, view) ->
            view?.isVisible = view?.id == tab.containerId
        }
        currentController = tabNavControllerMap[tab]?.navController
        currentController?.let { navController ->
            val startDestinationId = tab.graph?.startDestinationId
            if (startDestinationId != null && currentDestinationId != startDestinationId) {
                navController.navigate(
                    resId = startDestinationId,
                    args = null,
                    navOptions = navOptions {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                            inclusive = false
                        }
                        launchSingleTop = true
                        restoreState = true
                    },
                )
            }
        }
        currentController?.addOnDestinationChangedListener(onDestinationChangedListener)
    }

    fun setInitialNavController() {
        currentController = tabNavControllerMap[TabBarItem.TabHome]?.navController
        currentController?.addOnDestinationChangedListener(onDestinationChangedListener)
    }


    private fun isTabNavDestinationId(currentDestinationId: Int): Boolean =
        TabBarItem.entries.find { it.bottomTabVisibleDestinationIds.contains(currentDestinationId) } != null

    inner class LazyNavController(mainTab: TabBarItem) {
        val navController: NavController? by lazy(LazyThreadSafetyMode.NONE) {
            createNavController(mainTab)
        }

        private fun createNavController(tab: TabBarItem): NavController? {
            return if (tab.graph != null) {
                instaActivity.supportFragmentManager.findFragmentById(tab.containerId)
                    ?.findNavController()
            } else {
                null
            }
        }
    }

}