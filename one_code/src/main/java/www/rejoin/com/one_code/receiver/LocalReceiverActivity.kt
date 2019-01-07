package www.rejoin.com.one_code.receiver

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_local_receiver.*
import www.rejoin.com.one_code.R
import java.io.*

class LocalReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_receiver)
        Toast.makeText(this, show(), Toast.LENGTH_SHORT).show()

        btn_test.setOnClickListener {
            val text = edit_text.text.toString().trim()
            Log.i("test", text)
            FileUtils.save(text, this@LocalReceiverActivity)
        }
        btn_test2.setOnClickListener {
            val s = FileUtils.show(this@LocalReceiverActivity)
            Log.i("test", s)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "onDestroy")
//        val text = edit_text.text.toString().trim()
//        Log.i("test",text)
//        save(text)
    }

    fun show(): String {
        val builder = StringBuilder()
        var inputStream: FileInputStream? = null
        var reader: BufferedReader? = null
        try {
            inputStream = openFileInput("data")
            reader = BufferedReader(InputStreamReader(inputStream))
            while (reader.readLine() != null) {
                builder.append(reader.readLine())
            }
        } catch (e: Exception) {
        } finally {
            try {
                inputStream!!.close()
                reader!!.close()
            } catch (e: Exception) {

            }
        }
        return builder.toString()
    }

    fun save(str: String) {
        var out: FileOutputStream? = null
        var writer: BufferedWriter? = null
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE)
            writer = BufferedWriter(OutputStreamWriter(out))
            writer.write(str)
        } catch (e: Exception) {

        } finally {
            try {
                out!!.close()
                writer!!.close()
            } catch (e: Exception) {

            }
        }
    }
}
