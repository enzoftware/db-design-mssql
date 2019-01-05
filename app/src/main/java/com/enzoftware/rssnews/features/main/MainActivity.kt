package com.enzoftware.rssnews.features.main

import android.os.Bundle
import com.enzoftware.rssnews.R
import com.enzoftware.rssnews.base.BaseActivity
import com.enzoftware.rssnews.di.component.ActivityComponent
import com.enzoftware.rssnews.features.chrome.ChromeTabsWrapper
import com.enzoftware.rssnews.features.rss.RssFragment
import com.enzoftware.rssnews.model.Feed
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter : MainContract.Presenter
    private lateinit var wrapper: ChromeTabsWrapper


    override val layoutResource: Int = R.layout.activity_main

    override fun onLoadRssFragments(feeds: List<Feed>) {
        val fragmentList =  ArrayList<RssFragment>()
        val titles = ArrayList<String>()
        for (feed in feeds){
            //fragmentList.add(RssFragment.newInstance(feed))
            titles.add(feed.name)
        }

        //val adapter = RssFragmentAdapter(supportFragmentManager, fragmentList, titles)
        //viewPager.adapter = adapter

    }

    override fun init(state: Bundle?) {
        presenter.attach(this)
        // presenter.loadHelloText()
        textViewHello.setOnClickListener {
            // presenter.loadHelloText()
        }
        wrapper = ChromeTabsWrapper(this)
    }

    override fun inject(component: ActivityComponent) {
        component.inject(this)
    }


    override fun onStart() {
        super.onStart()
        wrapper.bindCustomTabsService()
    }

    override fun onStop() {
        super.onStop()
        wrapper.unbindCustomTabsService()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}
