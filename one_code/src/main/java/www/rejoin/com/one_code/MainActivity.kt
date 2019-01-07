package www.rejoin.com.one_code

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        AlertDialog.Builder(this).apply {
//            setTitle("danger")
//            setview
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.add -> {
                Toast.makeText(this@MainActivity, "add", Toast.LENGTH_SHORT).show()
            }
            R.id.remove -> {
                Toast.makeText(this@MainActivity, "remove", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
