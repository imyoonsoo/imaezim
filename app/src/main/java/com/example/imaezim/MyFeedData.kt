data class MyFeedData(
    val memoType: MemoType,
    val text: String? = null,
    val image: Int = 0,
    val video: Int = 0,
    val audio: Int = 0,
    val map: Int
) {
    enum class MemoType {
        TEXT, IMAGE, VIDEO, AUDIO
    }
}
