package www.rejoin.com.artilc

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
//            val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_test1)
//            image.startAnimation(animation)

            ObjectAnimator.ofFloat(image,"translationY",image.height.toFloat()).start()
        }
        btn2.setOnClickListener {
            val animation = AlphaAnimation(1f, 0.1f)
            animation.duration = 2000
            animation.fillAfter = true
            image.startAnimation(animation)
        }
        initView()

    }

    private fun initView() {
        val list = arrayListOf<String>()
        for (index in 1..100) {
            list.add(index.toString())
        }
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = adapter(list, this)

    }
}
