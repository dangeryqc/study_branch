package www.rejoin.com.one_code.NewsPractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import www.rejoin.com.one_code.R

class NewsActivity : AppCompatActivity() {

    companion object {
        fun startAction(title: String, content: String, context: Context) {
            val intent = Intent().setClass(context, NewsActivity::class.java)
            intent.putExtra("news_title", title)
            intent.putExtra("news_content", content)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        val newContentFragment = supportFragmentManager.findFragmentById(R.id.news_content_fragment) as NewContentFragment
        newContentFragment.refresh(title, content)
    }
}
