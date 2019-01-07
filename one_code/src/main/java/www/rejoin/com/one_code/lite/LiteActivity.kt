package www.rejoin.com.one_code.lite

import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_lite.*
import org.litepal.tablemanager.Connector
import www.rejoin.com.one_code.R

class LiteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lite)
        initView()
    }

    @SuppressLint("NewApi", "Recycle")
    private fun initView() {
        val list = ArrayList<String>()
        var cursor: Cursor? = null
        lite_btn.setOnClickListener {
            Connector.getDatabase()
            Log.i("test", list.toString())
        }

        save_lite.setOnClickListener {
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null)
            while (cursor!!.moveToNext()) {
                list.add(cursor!!.getString(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)))
            }
        }
    }
}
