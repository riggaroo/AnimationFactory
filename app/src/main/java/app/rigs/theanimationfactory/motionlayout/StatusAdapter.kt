package app.rigs.theanimationfactory.motionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.rigs.theanimationfactory.R
import kotlinx.android.synthetic.main.list_item_status.view.*

class StatusAdapter: ListAdapter<Status, StatusViewHolder>(DIFFER) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_status, parent, false)
        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFFER = object : DiffUtil.ItemCallback<Status>(){
            override fun areItemsTheSame(oldItem: Status, newItem: Status): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Status, newItem: Status): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class StatusViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(status: Status){
        view.textViewStatusText.text = status.text
        view.textViewName.text = status.name
    }

}