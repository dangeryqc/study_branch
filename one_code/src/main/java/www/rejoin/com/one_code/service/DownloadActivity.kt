package www.rejoin.com.one_code.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_download.*
import www.rejoin.com.one_code.R

class DownloadActivity : AppCompatActivity(), View.OnClickListener {
/***/

    var downloadBinder: DownloadService.downloadBinder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        initView()
        bindService(Intent(this, DownloadService::class.java), connectionService, Context.BIND_AUTO_CREATE)
    }

    private fun initView() {
        start_download.setOnClickListener(this)
        pause_download.setOnClickListener(this)
        cancel_download.setOnClickListener(this)
    }

    var connectionService = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {

        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            downloadBinder = p1 as DownloadService.downloadBinder
        }
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.start_download -> {
                val url = "http://wechat.clouclip.com/dist1002/m.apk"
                downloadBinder!!.startDownload(url)
            }
            R.id.pause_download -> {
                downloadBinder!!.pauseDownload()
            }
            R.id.cancel_download -> {
                downloadBinder!!.cancelDownload()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connectionService)
    }
}
