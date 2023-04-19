package com.milliybank.messanger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.milliybank.messanger.R
import com.milliybank.messanger.model.Chats
import com.milliybank.messanger.model.Feeds

class MessageAdapter(var context: Context,var list: ArrayList<Chats>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private var FEEDS = 0
        private var MESSAGES = 1
    }

    override fun getItemViewType(position: Int): Int {
        val chats = list[position]
        if (chats.feeds.size > 0)
            return FEEDS
        return MESSAGES
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == FEEDS){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.extra_feeds_item,parent,false)
            return RoomViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.messages_item,parent,false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val chats = list[position]

        if (holder is RoomViewHolder){
            val recyclerView = holder.recyclerView
            refreshAdapter(chats.feeds,recyclerView)

        }
        if (holder is MessageViewHolder){
            holder.pro.setImageResource(chats.message!!.pro)
            holder.fullname.text = chats.message!!.fullname
        }
    }

    // this function is called FeedsAdapter in this MessageAdapter
    private fun refreshAdapter(list:ArrayList<Feeds>,recyclerView: RecyclerView){
        val adapter = FeedsAdapter(list)
        recyclerView.adapter = adapter
    }


    inner class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView:RecyclerView = view.findViewById(R.id.recyclerView_hor_id)
        init {
            recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        }
    }

    inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var pro: ShapeableImageView = view.findViewById(R.id.room_pro_id)
        var fullname: TextView = view.findViewById(R.id.fullname_id)
        //  var fullname: TextView = view.findViewById(R.id.fullname_id)
    }
}