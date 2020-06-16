package com.example.broadcastinternet

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf


class BroadcastInternet : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {

        //if (p1!!.action == "android.net.wifi.WIFI_STATE_CHANGED"){
            MainActivity.changeState()
            Toast.makeText(p0, "Hi",Toast.LENGTH_LONG).show()
        //}

    }

    companion object {
        var isActivityVisible: Boolean = false

        fun activityResumed() {
            isActivityVisible = true// this will set true when activity resumed
        }

        fun activityPaused() {
            isActivityVisible = false// this will set false when activity paused
        }
    }
}