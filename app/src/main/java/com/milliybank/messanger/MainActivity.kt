package com.milliybank.messanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.messanger.adapter.MessageAdapter
import com.milliybank.messanger.model.Chats
import com.milliybank.messanger.model.Feeds
import com.milliybank.messanger.model.Message

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView_main_id)
        recyclerView.layoutManager = GridLayoutManager(this,1)

        refreshAdapter(data())
    }

    private fun data():ArrayList<Chats> {
        val list = ArrayList<Chats>()
        val feeds = ArrayList<Feeds>()

        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))
        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))
        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))
        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))
        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))
        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))
        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))
        feeds.add(Feeds(R.drawable.ali,"Alisher Daminov"))

        list.add(Chats(feeds))
        list.add(Chats(Message(R.drawable.ali,"Alisher Daminov")))
        list.add(Chats(Message(R.drawable.ali,"Alisher Daminov")))
        list.add(Chats(Message(R.drawable.ali,"Alisher Daminov")))
        list.add(Chats(Message(R.drawable.ali,"Alisher Daminov")))
        list.add(Chats(Message(R.drawable.ali,"Alisher Daminov")))
        list.add(Chats(Message(R.drawable.ali,"Alisher Daminov")))
        list.add(Chats(Message(R.drawable.ali,"Alisher Daminov")))

        return list
    }

    private fun refreshAdapter(data: ArrayList<Chats>) {
        val adapter = MessageAdapter(this,data)
        recyclerView.adapter = adapter
    }
}