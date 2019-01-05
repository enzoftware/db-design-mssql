package com.enzoftware.rssnews.features.main

import com.enzoftware.rssnews.model.Feed

interface MainRepository {
    fun parseFeeds(): List<Feed>
}