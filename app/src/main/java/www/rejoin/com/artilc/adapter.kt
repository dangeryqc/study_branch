package www.rejoin.com.artilc

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Administrator on 2018/12/13.
 */
class adapter(var data: ArrayList<String>, var context: Context) : RecyclerView.Adapter<adapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (data == null) {
            0
        } else {
            data.size
        }
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.title.text = data.get(position)
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView

        init {
            title = itemView.findViewById(R.id.title) as TextView
        }
    }
}