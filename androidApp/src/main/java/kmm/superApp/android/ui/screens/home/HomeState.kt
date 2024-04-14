package kmm.superApp.android.ui.screens.home

import kmm.superApp.domain.entity.HomeModel

data class HomeState (
    val homeList : List<HomeModel> = listOf(),
)
