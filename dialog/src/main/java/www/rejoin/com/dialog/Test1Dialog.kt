package www.rejoin.com.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity

/**
 * Created by Administrator on 2018/12/25.
 */
class Test1Dialog(context: Context, styleId: Int) : Dialog(context, styleId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = window.attributes
        val windowManager = window.windowManager
        val display = windowManager.defaultDisplay
        params.width = (display.width * 0.7).toInt()
        params.height = (display.height * 0.8).toInt()
        params.gravity = Gravity.CENTER
        window.attributes = params
    }
}