package com.example.doctor.ui.singleItemList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor.R

class SingleItemListAdapter(
    var singleItemList: List<String>,
    val context: Context?,
    private val itemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<SingleItemListAdapter.SingleItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleItemViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_suboption_layout, parent, false)
        return SingleItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return singleItemList.size
    }

    override fun onBindViewHolder(holder: SingleItemViewHolder, position: Int) {
        holder.bindItems(singleItemList.get(position), itemClickListener)
    }

    class SingleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(
            singleItemdata: String,
            itemClickListener: (Int) -> Unit
        ) {

            val singleItemTextView = itemView.findViewById<TextView>(R.id.tv_rowItem_option)
            val singleItemSubView =
                itemView.findViewById<TextView>(R.id.tv_rowItem_option_description)
            val singleItemSelectedImg = itemView.findViewById<ImageView>(R.id.ic_selected)

            singleItemTextView.text = singleItemdata


            singleItemTextView.setOnClickListener {
                itemClickListener(layoutPosition)
            }
        }
    }

}
