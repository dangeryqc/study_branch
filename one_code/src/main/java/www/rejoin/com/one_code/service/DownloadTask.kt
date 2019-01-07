package www.rejoin.com.one_code.service

import android.os.AsyncTask
import android.os.Environment
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.InputStream
import java.io.RandomAccessFile

/**
 * Created by Administrator on 2019/1/4.
 */
class DownloadTask : AsyncTask<String, Int, Int>() {

    lateinit var downloadListener: DownloadListener
    var isCancled = false
    var isPause = false
    var lastProgress = 0

    companion object {
        const val TYPE_SUCCESS = 0
        const val TYPE_FAIL = 1
        const val TYPE_PAUSE = 2
        const val TYPE_CANCLE = 3
    }

    fun setListener(listener: DownloadListener) {
        downloadListener = listener
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        val progress = values[0]
        if (progress!! > lastProgress) {
            downloadListener.onProgress(progress)
            lastProgress = progress
        }
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        when (result) {
            TYPE_SUCCESS -> {
                downloadListener.onSuccess()
            }
            TYPE_FAIL -> {
                downloadListener.onFailed()
            }
            TYPE_PAUSE -> {
                downloadListener.onPause()
            }
            TYPE_CANCLE -> {
                downloadListener.onCancled()
            }
        }
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg p0: String?): Int {
        var inputStream: InputStream? = null
        var saveFile: RandomAccessFile? = null
        var file: File? = null
        try {
            var downloadLength: Long = 0
            val downloadUrl = p0[0]
            val fileName = downloadUrl!!.substring(downloadUrl.lastIndexOf("/"))
            val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path
            file = File(directory + fileName)
            Log.i("test", file.toString())
            if (file.exists()) {
                downloadLength = file.length()
            }

            val length = getContentLength(downloadUrl)
            Log.i("test","length---"+ length.toString())
            Log.i("test","downloadLength---"+ downloadLength.toString())
            if (length == 0.toLong()) {
                return TYPE_FAIL
            } else if (length == downloadLength) {
                return TYPE_SUCCESS
            }

            val okHttpClient = OkHttpClient()
            val request = Request.Builder()
                    .url(downloadUrl)
                    .build()
            val response = okHttpClient.newCall(request).execute()
            inputStream = response.body()!!.byteStream()
            saveFile = RandomAccessFile(file, "rw")
            saveFile.seek(downloadLength)
            val b = ByteArray(1024)
            var len = 0
            var total = 0
            while (true) {
                len = inputStream.read(b)
                if (len == -1) {
                    break
                }
                if (isCancled) {
                    return TYPE_CANCLE
                } else if (isPause) {
                    return TYPE_PAUSE
                } else {
                    total += len
                    saveFile.write(b, 0, len)
                    val progress = ((total + downloadLength) * 100 / length).toInt()
                    publishProgress(progress)
                }
            }
            response.body()!!.close()
            return TYPE_SUCCESS
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close()
                }
                if (saveFile != null) {
                    saveFile.close()
                }

                if (isCancled && file != null) {
                    file.delete()
                }
            } catch (e: Exception) {

            }
        }
        return TYPE_FAIL
    }

    private fun getContentLength(urlPath: String): Long {
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
                .url(urlPath)
                .build()
        val response = okHttpClient.newCall(request).execute()
        if (response.isSuccessful) {
            val contentLength = response.body()!!.contentLength()
            response.close()
            return contentLength
        }
        return 0
    }

    fun cancelDownload() {
        isCancled = true
    }

    fun pausedDownload() {
        isPause = true
    }
}