package com.enzoftware.rssnews.features.chrome

import android.content.Context
import android.support.customtabs.CustomTabsClient
import android.content.ServiceConnection
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.customtabs.CustomTabsServiceConnection
import android.support.customtabs.CustomTabsSession
import com.enzoftware.rssnews.R


class ChromeTabsWrapper(private val mContext: Context) : ServiceConnectionCallback {
    private var mCustomTabsSession: CustomTabsSession? = null
    private var mConnection: CustomTabsServiceConnection? = null
    private var mClient: CustomTabsClient? = null


    fun openCustomtab(url: String) {
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(mContext, R.color.colorPrimary))
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(mContext, Uri.parse(url))
    }

    fun bindCustomTabsService() {
        if (mClient != null) return
        if (mConnection == null) {
            mConnection = ServiceConnection(this)
        }
        val ok = CustomTabsClient.bindCustomTabsService(mContext, CUSTOM_TAB_PACKAGE_NAME, mConnection)
    }

    fun unbindCustomTabsService() {
        if (mConnection == null) return
        mContext.unbindService(mConnection as ServiceConnection)
        mClient = null
        mCustomTabsSession = null
        mConnection = null
    }

    override fun onServiceConnected(client: CustomTabsClient) {
        mClient = client
    }

    override fun onServiceDisconnected() {
        mClient = null
    }

    companion object {

        private const val CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome"
    }
}