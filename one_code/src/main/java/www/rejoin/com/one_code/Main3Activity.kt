package www.rejoin.com.one_code

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        initView()
    }

    private fun initView() {
        btn1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data", "danger")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
