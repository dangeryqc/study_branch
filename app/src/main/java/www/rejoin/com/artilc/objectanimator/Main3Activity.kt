package www.rejoin.com.artilc.objectanimator

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*
import www.rejoin.com.artilc.R

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        initView()
    }

    private fun initView() {
        btn1.setOnClickListener {
            //            ObjectAnimator.ofFloat(image, "translationY", -image.height.toFloat()).start()
            val animator = ObjectAnimator.ofInt(btn1, "backgroundColor", 0xffff8080.toInt(), 0xff8080ff.toInt())
            animator.duration = 3000
            animator.setEvaluator(ArgbEvaluator())
            animator.repeatCount = ValueAnimator.INFINITE
            animator.repeatMode = ValueAnimator.RESTART
            animator.start()
        }

        btn2.setOnClickListener {
            val animatorSet = AnimatorSet()
            animatorSet.playTogether(
                    ObjectAnimator.ofFloat(image, "translationX", 0F, 200F),
                    ObjectAnimator.ofFloat(image, "translationY", 0f, 200f),
                    ObjectAnimator.ofFloat(image, "rotation", 0f, 90f),
                    ObjectAnimator.ofFloat(image, "scaleX", 1f, 2f),
                    ObjectAnimator.ofFloat(image, "scaleY", 1f, 2f),
                    ObjectAnimator.ofFloat(image, "alpha", 1f, 0.1f, 1f)
            )
            animatorSet.setDuration(5000).start()

        }


    }
}
