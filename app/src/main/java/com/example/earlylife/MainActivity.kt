//package com.example.earlylife
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        findViewById<View>(R.id.Begin).setOnClickListener {
//            //startActivity(Intent(applicationContext, TabbedActivity::class.java))
//            startActivity(Intent(applicationContext, TabbedActivity::class.java))
//        }
//    }
//
//}


package com.example.earlylife

import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.Begin).setOnClickListener { showCustomDialog() }
    }

    private fun isConnected(mainActivity: MainActivity): Boolean {
        val connectivityManager = mainActivity.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val mobileDataConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        val wifiConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return wifiConnection != null && wifiConnection.isConnected || mobileDataConnection != null && mobileDataConnection.isConnected
    }

    @RequiresApi(Build.VERSION_CODES.P)

    open fun showCustomDialog() {
        val alertBuilder = AlertDialog.Builder(this@MainActivity)
        alertBuilder.setMessage("Allow EarlyLife to connect to the internet or continue offline?. Your mobile data or Wifi will be consumed if you select to connect to the internet.")
            .setCancelable(true).setPositiveButton(
                "Continue Offline?"
            ) { _, _ -> startActivity(Intent(applicationContext, TabbedActivity::class.java)) }
            .setNeutralButton(
                "Connect Using Mobile Data?"
            ) { _, _ ->
                val alertBuilder = AlertDialog.Builder(this@MainActivity)
                if (isConnected(this@MainActivity)) {
                    startActivity(Intent(applicationContext, TabbedActivity::class.java))
                } else {
                    alertBuilder.setMessage("No Data Connection Available.").setCancelable(true)
                        .setPositiveButton(
                            "Continue Offline?"
                        ) { _, _ ->
                            startActivity(
                                Intent(
                                    applicationContext,
                                    TabbedActivity::class.java
                                )
                            )
                        }.setNegativeButton(
                            "Try Again?"
                        ) { _, _ -> //startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            findViewById<View>(R.id.Begin).performClick()
                        }.show()
                }
            }.setNegativeButton(
                "Connect Using Wifi?"
            ) { _, _ ->
                val alertBuilder = AlertDialog.Builder(this@MainActivity)
                if (isConnected(this@MainActivity)) {
                    startActivity(Intent(applicationContext, TabbedActivity::class.java))
                } else {
                    alertBuilder.setMessage("No Data Connection Available.").setCancelable(true)
                        .setPositiveButton(
                            "Continue Offline?"
                        ) { _, _ ->
                            startActivity(
                                Intent(
                                    applicationContext,
                                    TabbedActivity::class.java
                                )
                            )
                        }.setNegativeButton(
                            "Try Again?"
                        ) { _, _ -> //startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            findViewById<View>(R.id.Begin).performClick()
                        }.show()
                }
            }.show()
    }
}