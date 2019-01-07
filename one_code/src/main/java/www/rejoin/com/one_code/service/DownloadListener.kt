package www.rejoin.com.one_code.service

/**
 * Created by Administrator on 2019/1/4.
 */
interface DownloadListener {
    fun onProgress(progress: Int)
    fun onSuccess()
    fun onFailed()
    fun onCancled()
    fun onPause()
}