package com.milliybank.messanger.model

class Chats {

    var message:Message?=null
    var feeds:ArrayList<Feeds> = ArrayList()

    constructor(message: Message?) {
        this.message = message
    }

    constructor(feeds: ArrayList<Feeds>) {
        this.feeds = feeds
    }


}