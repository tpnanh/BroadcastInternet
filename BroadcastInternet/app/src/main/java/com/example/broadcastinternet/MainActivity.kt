package com.example.broadcastinternet

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var internetStatus:TextView
        fun changeState(){
            if (internetStatus.text.equals("Internet Disconnected.")) {
                internetStatus.setText("Internet Connected.")
            } else {
                internetStatus.setText("Internet Disconnected.")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        internetStatus = findViewById(R.id.internet_status)

        val connectivityManager: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (networkInfo != null && networkInfo.isConnected()) {
                changeTextStatus(true);
            } else {
                changeTextStatus(false);
            }
            networkInfo?.isConnected ?: false
        }
        else false
    }

    // Method to change the text status
    fun changeTextStatus(isConnected: Boolean) {
        if (isConnected) {
            internetStatus.setText("Internet Connected.")
        } else {
            internetStatus.setText("Internet Disconnected.")
        }
    }

    override fun onPause() {
        super.onPause()
        BroadcastInternet.activityPaused()// On Pause notify the Application
    }

    override fun onResume() {
        super.onResume()
        BroadcastInternet.activityResumed()// On Resume notify the Application
    }
}
