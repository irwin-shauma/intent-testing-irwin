package com.irwin.intenttesting

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.button_pindah_activity)
        btnPindahActivity.setOnClickListener(this)

        val btnPindahActivityData: Button = findViewById(R.id.button_pindah_activity_data)
        btnPindahActivityData.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.button_dial_phone)
        btnDialPhone.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.button_pindah_activity -> {
                // Membuat package bagu
                val intentPindah = Intent(this@MainActivity, PindahActivity::class.java)
                startActivity(intentPindah)
            }
            R.id.button_pindah_activity_data -> {
                val intentPindahData = Intent(this@MainActivity, PindahActivityData::class.java)
                intentPindahData.putExtra(PindahActivityData.EXTRA_NAME, "Irwin Shauma Rizky")
                intentPindahData.putExtra(PindahActivityData.EXTRA_AGE, "24")
                startActivity(intentPindahData)
            }
            R.id.button_dial_phone -> {
                val nomorTelepon = 222111
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomorTelepon"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}