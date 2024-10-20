package kz.alibek.testinstagram.tabbar.model

import kz.alibek.testinstagram.R

enum class TabBarItem(
    val tabId: Int,
    val graph: NavigationGraph?,
    val bottomTabVisibleDestinationIds: List<Int>,
    val containerId: Int,
) {

    TabHome(
        tabId = R.id.tab_home,
        graph = NavigationGraph(
            startDestinationId = R.id.home_nav_graph,
            popDestinationId = R.id.homeFragment,
        ),
        bottomTabVisibleDestinationIds = listOf(R.id.homeFragment),
        containerId = R.id.globalContainer,
    ),
    TabProfile(
        tabId = R.id.tab_profile,
        graph = NavigationGraph(
            startDestinationId = R.id.profile_nav_graph,
            popDestinationId = R.id.profileFragment,
        ),
        bottomTabVisibleDestinationIds = listOf(R.id.profileFragment),
        containerId = R.id.globalContainer,
    ),
    TabSearch(
        tabId = R.id.tab_search,
        graph = NavigationGraph(
            startDestinationId = R.id.search_nav_graph,
            popDestinationId = R.id.searchFragment,
        ),
        bottomTabVisibleDestinationIds = listOf(R.id.searchFragment),
        containerId = R.id.globalContainer,
    ),
    TabAddPost(
        tabId = R.id.tab_add_post,
        graph = NavigationGraph(
            startDestinationId = R.id.add_post_nav_graph,
            popDestinationId = R.id.addPostFragment,
        ),
        bottomTabVisibleDestinationIds = listOf(R.id.addPostFragment),
        containerId = R.id.globalContainer,
    ),
    TabNotification(
        tabId = R.id.tab_notification,
        graph = NavigationGraph(
            startDestinationId = R.id.notification_nav_graph,
            popDestinationId = R.id.notificationFragment,
        ),
        bottomTabVisibleDestinationIds = listOf(R.id.notificationFragment),
        containerId = R.id.globalContainer,
    );
}

class NavigationGraph(
    val startDestinationId: Int,
    val popDestinationId: Int,
)