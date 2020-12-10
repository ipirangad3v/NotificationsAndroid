package com.ipsoft.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ipsoft.notification.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var detailsBinding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = detailsBinding.root
            setContentView(view)


        detailsBinding.txtMessage.text = intent.getStringExtra(EXTRA_MESSAGE)


    }
    companion object {
        const val EXTRA_MESSAGE = "message"
    }
}