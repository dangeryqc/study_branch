package www.rejoin.com.one_code.NewsPractice

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import www.rejoin.com.one_code.R
import java.util.*

/**
 * Created by Administrator on 2018/12/28.
 */

class NewTitleFragment : Fragment() {

    companion object {
        private var isTwoPan: Boolean = false
    }

    private var mView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.news_fragment_title, container, false)
        val recycler_view = mView!!.findViewById(R.id.news_title_recycler_view) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(activity)
        recycler_view.layoutManager = linearLayoutManager
        val adapter = newsAdapter(getNews(), fragmentManager!!, activity as Context)
        recycler_view.adapter = adapter
        return mView
    }

    fun getNews(): ArrayList<News> {
        val list = ArrayList<News>()
        for (index in 0..50) {
            val news = News("this is news title" + index, getRandomLengthContent("this is news content" + index + "."))
            list.add(news)
        }
        return list
    }

    fun getRandomLengthContent(content: String): String {
        val length = Random().nextInt(20) + 1
        val stringBuilder = StringBuilder()
        for (index in 0..length) {
            stringBuilder.append(content)
        }
        return stringBuilder.toString()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPan = activity!!.findViewById<FrameLayout>(R.id.news_content_layout) != null
    }

    class newsAdapter(var newsList: ArrayList<News>, var fragmentManager: FragmentManager, var context: Context) : RecyclerView.Adapter<newsAdapter.newsViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.title_item, parent, false)
            val holder = newsViewHolder(view)
            view.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPan) {
                    val fragment = fragmentManager.findFragmentById(R.id.news_content_fragment) as NewContentFragment
                    fragment.refresh(news.title, news.content)
                } else {
                    NewsActivity.startAction(news.title, news.content, context)
                }
            }
            return holder
        }

        override fun getItemCount(): Int {
            return newsList.size
        }

        override fun onBindViewHolder(holder: newsViewHolder, position: Int) {
            holder.mNewsTitle.text = newsList[position].title
        }

        class newsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val mNewsTitle: TextView = itemView.findViewById(R.id.news_title) as TextView
        }
    }
}
