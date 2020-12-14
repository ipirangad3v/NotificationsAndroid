package com.ipsoft.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Notification
 *  Date:       14/12/2020
 */

class NotificationActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, intent.getStringExtra(EXTRA_MESSAGE), Toast.LENGTH_SHORT).show()
        NotificationManagerCompat.from(context).cancelAll()
    }

    companion object {
        const val EXTRA_MESSAGE = "message"
    }
}