package kmm.superApp.domain.repo

import kmm.superApp.domain.entity.HomeModel

expect interface HomeRepo {

    fun getHome(): List<HomeModel>
}