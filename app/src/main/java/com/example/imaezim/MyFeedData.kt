data class MyFeedData(
    val memoType: MemoType,
    val inout : Int,
    val lat : Double,
    val lng : Double,
    val addressDetail : String,
    val text: String? = null,
    val image: String? = null,
    val video: String? = null,
    val audio: String? = null,
    val time : String
) {
    enum class MemoType {
        TEXT, IMAGE, VIDEO, AUDIO
    }
}
