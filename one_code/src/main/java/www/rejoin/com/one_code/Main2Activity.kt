package www.rejoin.com.one_code


import android.os.Bundle
import android.support.v4.app.Fragment
import www.rejoin.com.one_code.fragment.BottomFragment
import www.rejoin.com.one_code.fragment.TopFragment

class Main2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()
    }

    private fun initView() {
        replaceFragment(TopFragment(),R.id.container1)
        replaceFragment(BottomFragment(),R.id.container1)
    }

    fun replaceFragment(fragment: Fragment, layoutId: Int) {
        supportFragmentManager.beginTransaction().replace(layoutId, fragment).commitAllowingStateLoss()
    }
}
