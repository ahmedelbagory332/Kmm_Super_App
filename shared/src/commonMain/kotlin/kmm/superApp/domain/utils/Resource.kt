package kmm.superApp.domain.utils



//sealed class Resource<T>(val data: T? = null, val message: String? = null) {
//    class Success<T>(data: T) : Resource<T>(data)
//    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
//    class Loading<T>(data: T? = null) : Resource<T>(data)
//}


sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error<out T>(val message: String?) : Resource<T>()
    data object Loading : Resource<Nothing>()
}
