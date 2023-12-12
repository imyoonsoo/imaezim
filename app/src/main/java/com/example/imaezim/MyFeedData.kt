data class MyFeedData(
    val memoType: MemoType,
    val inout : Int,
    val lat : Double,
    val lng : Double,
    val addressDetail : String,
    val text: String? = null,
    val image: Int = 0,
    val video: Int = 0,
    val audio: Int = 0,
) {
    enum class MemoType {
        TEXT, IMAGE, VIDEO, AUDIO
    }
}
