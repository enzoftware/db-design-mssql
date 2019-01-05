package com.enzoftware.rssnews.util

import android.content.Context
import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Utils{
    companion object {
        fun readFromAssets (context: Context, nameFile: String): String{
            val assetManager: AssetManager = context.assets
            var ret: String ?= null
            try {
                val reader  = BufferedReader(InputStreamReader(assetManager.open(nameFile)))
                val builder = StringBuilder()
                while ( reader.readLine()  != null) {
                    builder.append(reader.readLine())
                }
                ret = builder.toString()
            } catch (e : IOException) {
                e.printStackTrace()
            }
            return ret!!
        }
    }
}