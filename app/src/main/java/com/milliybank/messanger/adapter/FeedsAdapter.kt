package com.milliybank.messanger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.milliybank.messanger.R
import com.milliybank.messanger.model.Feeds

class FeedsAdapter(var list: ArrayList<Feeds>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feeds_item,parent,false)
        return FeedsViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feeds = list[position]

        if (holder is FeedsViewHolder){
            holder.pro.setImageResource(feeds.pro)
            holder.fullname.text = feeds.fullname
        }
    }

    inner class FeedsViewHolder(view: View):RecyclerView.ViewHolder(view){
        var pro:ShapeableImageView = view.findViewById(R.id.rooms_pro_id)
        var fullname:TextView = view.findViewById(R.id.fullnames_id)
    }
}