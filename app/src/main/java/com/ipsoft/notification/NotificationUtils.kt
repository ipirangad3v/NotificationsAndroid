package com.ipsoft.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder

object NotificationUtils {

    val CHANNEL_ID = "default"

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(context: Context) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelName = context.getString(R.string.notif_channel_name)
        val channelDescription = context.getString(R.string.notif_channel_description)
        val channel = NotificationChannel(
            CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = channelDescription
            enableLights(true)
            lightColor = Color.GREEN
            enableVibration(true)
            vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)

        }
        notificationManager.createNotificationChannel(channel)
    }

    private fun getContentIntent(context: Context): PendingIntent? {

        val detailsIntent = Intent(context, DetailsActivity::class.java).apply {
            putExtra(DetailsActivity.EXTRA_MESSAGE, "Via notificação")
        }
        return TaskStackBuilder.create(context)
            .addNextIntentWithParentStack(detailsIntent)
            .getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    fun notificationSimple(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(context)
        }
        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_favorite)
            .setContentTitle(context.getString(R.string.notif_title))
            .setContentText(context.getString(R.string.notif_text))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ActivityCompat.getColor(context, R.color.design_default_color_primary))
            .setDefaults(Notification.DEFAULT_ALL)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(1, notificationBuilder.build())

    }

    fun notificationWithTapAction(context: Context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(context)
        }
        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_favorite)
            .setContentTitle(context.getString(R.string.notif_title))
            .setContentText(context.getString(R.string.notif_text))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ActivityCompat.getColor(context, R.color.design_default_color_primary))
            .setDefaults(Notification.DEFAULT_ALL)
            .setContentIntent(getContentIntent(context))
            .setAutoCancel(true)
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(2, notificationBuilder.build())

    }
}
