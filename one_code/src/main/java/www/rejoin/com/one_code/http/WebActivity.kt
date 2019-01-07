package www.rejoin.com.one_code.http

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*
import www.rejoin.com.one_code.R
import java.net.HttpURLConnection
import java.net.URL

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        init()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun init() {
        web_view.settings.javaScriptEnabled = true
        web_view.webViewClient = WebViewClient()
        web_view.loadUrl("http://www.baidu.com")
    }

    private fun initHttp(){
        val url = URL("http://www.baidu.com")
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod="GET"
        httpURLConnection.connectTimeout=5000
        httpURLConnection.readTimeout=5000
        val stream = httpURLConnection.inputStream

    }
}
