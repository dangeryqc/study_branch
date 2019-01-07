package www.rejoin.com.dialog

import android.annotation.TargetApi
import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initView() {
        btn1.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
                    .setTitle("test")
                    .setMessage("test")
                    .setPositiveButton("ok") { p0, p1 ->

                    }
                    .setNegativeButton("cancel", { p0, p1 ->

                    })
                    .create()

            dialog.show()

            val window = dialog.window
            val d = windowManager.defaultDisplay
            val params = window.attributes
//            params.height = (d.height * 0.8).toInt()
            params.height = d.height
//            params.width = (d.width * 0.8).toInt()
            params.width = d.width
            params.gravity = Gravity.CENTER
            params.alpha = 1f
            window.attributes = params
            
        }

        btn2.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity, R.style.testDialog)
                    .setView(R.layout.test2)
                    .create()
            dialog.show()
//            val window = dialog.window
//            val display = windowManager.defaultDisplay
//            val params = window.attributes
//            params.height = display.height
//            params.width = display.width
//            params.gravity = Gravity.CENTER
//            window.attributes = params
        }

        btn3.setOnClickListener {
            val dialog = Test1Dialog(this@MainActivity, R.style.testDialog)
            dialog.setContentView(R.layout.test2)
            dialog.show()
        }

        btn4.setOnClickListener {
            val dialog = test2Dialog(this@MainActivity, R.style.testDialog)
            val view = layoutInflater.inflate(R.layout.test2, null)
            dialog.setContentView(view)
            dialog.show()
        }

//        val view = viewStub.inflate()

    }
}
