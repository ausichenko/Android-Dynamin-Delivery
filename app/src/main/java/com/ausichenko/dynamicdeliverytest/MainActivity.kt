package com.ausichenko.dynamicdeliverytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun routeToDynamic(view: View) {
        val splitInstallManager = SplitInstallManagerFactory.create(this)

        val request = SplitInstallRequest
            .newBuilder()
            .addModule("dynamicfeature")
            .build()

        splitInstallManager
            .startInstall(request)
            .addOnSuccessListener { sessionId ->
                val c = Class.forName("com.ausichenko.dynamicfeature.DynamicActivity")
                startActivity(Intent(this, c))
            }
            .addOnFailureListener { exception ->

            }
    }
}
