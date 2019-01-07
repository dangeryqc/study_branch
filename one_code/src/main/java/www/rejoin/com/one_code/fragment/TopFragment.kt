package www.rejoin.com.one_code.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import www.rejoin.com.one_code.R

/**
 * Created by Administrator on 2018/12/28.
 */
class TopFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.top_fragment,container,false)
    }
}