package kmm.superApp.android.ui.screens.spaceLaunches


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmm.superApp.data.dto.RocketLaunch
import kmm.superApp.domain.use_case.LaunchesUseCase
import kotlinx.coroutines.launch


class LaunchesViewModel(
    val launchesUseCase: LaunchesUseCase
) : ViewModel() {

    private var resultList: List<RocketLaunch> = listOf()

    private val _launchesState = mutableStateOf(LaunchesState())
    val launches: State<LaunchesState>
        get() = _launchesState


    init {
        getLaunches()
    }


    private fun getLaunches() {
        viewModelScope.launch {
            try {
                _launchesState.value = LaunchesState(isLoading = true)
                resultList = launchesUseCase()
                _launchesState.value = LaunchesState(launches = resultList)
            } catch (e: Exception) {
                if (resultList.isNotEmpty()) {
                    _launchesState.value = LaunchesState(
                        launches = resultList
                    )

                }else{
                    _launchesState.value = LaunchesState(
                        error = e.message ?: "An unexpected error happened"
                    )
                }
            }
        }
    }
}

