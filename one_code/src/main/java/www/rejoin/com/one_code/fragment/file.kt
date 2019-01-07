package www.rejoin.com.one_code.fragment

import android.content.Context

import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter

/**
 * Created by Administrator on 2019/1/3.
 */

class file {
    private fun save(str: String, context: Context) {
        var out: FileOutputStream? = null
        try {
            out = context.openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(out!!))
            writer.write(str)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                if (out != null) {
                    out.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()

            }

        }
    }
}
