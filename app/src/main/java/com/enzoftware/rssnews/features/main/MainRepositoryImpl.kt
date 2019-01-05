package com.enzoftware.rssnews.features.main

import android.content.Context
import com.enzoftware.rssnews.model.Feed
import com.enzoftware.rssnews.util.Utils
import com.google.gson.Gson
import java.util.*

class MainRepositoryImpl (private val context: Context): MainRepository{
    override fun parseFeeds(): List<Feed> {
        val gson = Gson()
        val jsonString = Utils.readFromAssets(context, MainRepositoryImpl.RSS_FILE)
        val feeds = gson.fromJson(jsonString, Array<Feed>::class.java)
        return Arrays.asList(*feeds)
    }

    companion object {
        private const val RSS_FILE = "rss.json"
    }
}