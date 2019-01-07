package www.rejoin.com.artilc

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {
    companion object {
        val TAG: String = Main4Activity::class.java.name
        val list = ArrayList<Int>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        initView()
    }

    private fun initView() {

        for (index in 0..100) {
            list.add(index)
        }

        btn1.setOnClickListener {
            myAsyncTask(show_text, this@Main4Activity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        }

        btn2.setOnClickListener {
            val intnet = Intent(this@Main4Activity, LocalIntentService::class.java)
            intnet.putExtra("task", "com.rejoin.clouclip1")
            startService(intnet)
            intnet.putExtra("task", "com.rejoin.clouclip2")
            startService(intnet)
        }
    }

    class myAsyncTask(var view: TextView, val context: Context) : AsyncTask<Int, Int, Int>() {
        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            Toast.makeText(context, "onPostExecute", Toast.LENGTH_SHORT).show()
            Log.i(TAG, "onPostExecute")
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            view.text = values[0].toString()
        }

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(context, "onPreExecute", Toast.LENGTH_SHORT).show()
            Log.i(TAG, "onPreExecute")
        }

        override fun doInBackground(vararg p0: Int?): Int {
            for (item in list) {
                Thread.sleep(500)
                publishProgress(item)
            }
            return list.size
        }
    }
}
