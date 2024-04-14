package kmm.superApp.android.ui.screens.home


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kmm.superApp.domain.use_case.HomeUseCase


class HomeViewModel(
    val homeUseCase: HomeUseCase
) : ViewModel() {


    private val _homeState = mutableStateOf(HomeState())
    val homeState: State<HomeState>
        get() = _homeState


    init {
        getHome()
    }


    private fun getHome() {
        _homeState.value = HomeState(homeList = homeUseCase())
    }
}

