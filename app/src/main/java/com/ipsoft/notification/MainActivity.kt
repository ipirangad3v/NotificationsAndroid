package com.ipsoft.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ipsoft.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.btnSimple.setOnClickListener {
            NotificationUtils.notificationSimple(this)
        }
        mainBinding.btnTapAction.setOnClickListener {
            NotificationUtils.notificationWithTapAction(this)
        }
        mainBinding.btnBigText.setOnClickListener {
            NotificationUtils.notificationBigText(this)
        }
        mainBinding.btnActionButton.setOnClickListener {
            NotificationUtils.notificationWithButtonAction(this)
        }
        mainBinding.btnDirectReply.setOnClickListener {
            NotificationUtils.notificationAutoReply(this)
        }
//        mainBinding.btnInbox.setOnClickListener {
//            NotificationUtils.notificationInbox(this)
//        }
//        mainBinding.btnHeadsUp.setOnClickListener {
//            NotificationUtils.notificationHeadsUp(this)
//        }

    }
}