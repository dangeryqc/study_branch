package www.rejoin.com.artilc


import android.app.IntentService
import android.content.Intent
import android.os.SystemClock
import android.util.Log


/**
 * Created by Administrator on 2018/12/19.
 */
class LocalIntentService : IntentService("LocalIntentService") {
    override fun onHandleIntent(p0: Intent?) {
        val str = p0!!.getStringExtra("task")
        Log.i("test",str)
        SystemClock.sleep(3000)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test","service onDestroy")
    }
}