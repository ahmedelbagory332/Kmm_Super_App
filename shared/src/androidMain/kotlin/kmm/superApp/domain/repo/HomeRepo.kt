package kmm.superApp.domain.repo

import kmm.superApp.domain.entity.HomeModel

actual interface HomeRepo {

    actual fun getHome(): List<HomeModel>
}