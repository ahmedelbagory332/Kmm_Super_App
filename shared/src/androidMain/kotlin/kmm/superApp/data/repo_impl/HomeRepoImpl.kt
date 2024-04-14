package kmm.superApp.data.repo_impl

import kmm.superApp.R
import kmm.superApp.domain.entity.HomeModel
import kmm.superApp.domain.repo.HomeRepo

class HomeRepoImpl() : HomeRepo {
    override fun getHome(): List<HomeModel> {
       return listOf(
           HomeModel(R.drawable.launcher_icon, "Space Launcher", "launches"),
           HomeModel(R.drawable.movie_icon, "Movies", "movies"),
       )
    }


}