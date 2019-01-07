package www.rejoin.com.artilc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn.setOnClickListener {
            startActivity(Intent(this@Main2Activity, MainActivity::class.java))
            overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim)
        }
    }
}
