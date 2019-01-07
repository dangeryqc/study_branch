package www.rejoin.com.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity

/**
 * Created by Administrator on 2018/12/25.
 */
class test2Dialog(context: Context, themeId: Int) : Dialog(context, themeId) {
    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = window.attributes
        val manager = window.windowManager
        val display = manager.defaultDisplay
        params.width = display.width
        params.height = (display.height * 0.8).toInt()
        params.gravity = (Gravity.LEFT) or (Gravity.BOTTOM)
        window.attributes = params
    }
}