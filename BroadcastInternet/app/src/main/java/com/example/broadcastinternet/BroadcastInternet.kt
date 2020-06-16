package com.example.broadcastinternet

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager


@Suppress("DEPRECATION")
class BroadcastInternet : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {

        if (p1!!.action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            MainActivity.changeState()
        }

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