package kmm.superApp.domain.use_case

import kmm.superApp.domain.entity.HomeModel
import kmm.superApp.domain.repo.HomeRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeUseCase : KoinComponent {

    private val homeRepo: HomeRepo by inject()

     operator fun invoke(): List<HomeModel> {
        return homeRepo.getHome()
    }

}