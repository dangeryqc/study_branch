package www.rejoin.com.one_code.NewsPractice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import www.rejoin.com.one_code.R

/**
 * Created by Administrator on 2018/12/28.
 */
class NewContentFragment : Fragment() {

    private var mView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.news_fragment_content, container, false)
        return mView
    }

    fun refresh(title: String, content: String) {
        val titleView = mView!!.findViewById(R.id.news_title) as TextView
        val contentView = mView!!.findViewById(R.id.news_content) as TextView
        titleView.text = title
        contentView.text = content

    }
}