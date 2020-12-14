package com.ipsoft.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.RemoteInput

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Notification
 *  Date:       14/12/2020
 */

class ReplyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        val message = remoteInput?.getCharSequence(EXTRA_TEXT_REPLY)
        if (message != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
        val notificationId = intent.getIntExtra(EXTRA_NOTIFICATION_ID, -1)
        NotificationUtils.notificationReplied(context, notificationId)
    }

    companion object {
        const val EXTRA_TEXT_REPLY = "action_text_reply"
        const val EXTRA_NOTIFICATION_ID = "notif_id"
    }
}