package www.rejoin.com.one_code.service

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Environment
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.widget.Toast
import www.rejoin.com.one_code.R
import java.io.File

/**
 * Created by Administrator on 2019/1/4.
 */
class DownloadService : Service() {

    var downloadTask: DownloadTask? = null
    var downloadUrl: String? = null
    var mBinder: downloadBinder = downloadBinder()
    private val listener = object : DownloadListener {
        override fun onProgress(progress: Int) {
            getNotificationManager().notify(1, getNotification("downloading", progress))
        }

        override fun onSuccess() {
            stopForeground(true)
            getNotificationManager().notify(1, getNotification("download success", -1))
            Toast.makeText(this@DownloadService, "download success", Toast.LENGTH_SHORT).show()
        }

        override fun onFailed() {
            downloadTask = null
            stopForeground(true)
            getNotificationManager().notify(1, getNotification("download fail", -1))
            Toast.makeText(this@DownloadService, "download fail", Toast.LENGTH_SHORT).show()
        }

        override fun onCancled() {
            downloadTask = null
            stopForeground(true)
            getNotificationManager().notify(1, getNotification("download cancel", -1))
            Toast.makeText(this@DownloadService, "download cancel", Toast.LENGTH_SHORT).show()
        }

        override fun onPause() {
            downloadTask = null
            Toast.makeText(this@DownloadService, "download paused", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onBind(p0: Intent?): IBinder {
        return mBinder
    }

    inner class downloadBinder : Binder() {
        fun startDownload(url: String) {
            if (downloadTask == null) {
                downloadUrl = url
                downloadTask = DownloadTask()
                downloadTask!!.setListener(listener)
                downloadTask!!.execute(downloadUrl)
                startForeground(1, getNotification("downloading...", 0))
            }
        }

        fun cancelDownload() {
            if (downloadTask != null) {
                downloadTask!!.cancelDownload()
            } else {
                if (downloadUrl != null) {
                    val fileName = downloadUrl!!.substring(downloadUrl!!.lastIndexOf("/"))
                    val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path
                    val file = File(directory + fileName)
                    if (file.exists()) {
                        file.delete()
                    }
                    getNotificationManager().cancel(1)
                    Toast.makeText(this@DownloadService, "cancel", Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun pauseDownload() {
            downloadTask!!.pausedDownload()
        }
    }

    private fun getNotificationManager(): NotificationManager {
        return getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun getNotification(title: String, progress: Int): Notification {
        val intent = Intent(this, DownloadActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        return NotificationCompat.Builder(this, "1").apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            setContentIntent(pendingIntent)
            setContentTitle(title)
            if (progress > 0) {
                setContentText(progress.toString() + "%")
                setProgress(100, progress, false)
            }
        }.build()

    }
}