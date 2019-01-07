package www.rejoin.com.artilc

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        initView()
    }

    private fun initView() {
        val progressBar = ProgressBar(this)
        val dialog = Dialog(this)
    }
}
