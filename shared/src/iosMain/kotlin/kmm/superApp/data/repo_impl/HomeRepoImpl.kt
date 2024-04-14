package kmm.superApp.data.repo_impl

import kmm.superApp.domain.entity.HomeModel
import kmm.superApp.domain.repo.HomeRepo

class HomeRepoImpl() : HomeRepo {
    override fun getHome(): List<HomeModel> {
       return listOf(
           HomeModel("launcher_icon", "Space Launcher", "launches"),
           HomeModel("movie_icon", "Movies", "movies"),
       )
    }
}