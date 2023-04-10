package dev.mobiagri.app

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.Constants.TAG
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.hiennv.flutter_callkit_incoming.CallkitSoundPlayerService

class MyFirebaseMessagingService : FirebaseMessagingService() {
    companion object {
        const val INCOMING_CALL = "incoming_call";
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d(TAG, "From: ${message.from}")
        val data = message.data
        val type = data["type"];
        Log.d(TAG, "type: $type")
        if(type == INCOMING_CALL) {
            showIncomingCall()
        }
        super.onMessageReceived(message)
    }

    private  fun showIncomingCall() {
        val intent = Intent(this, SoundService::class.java)
        startService(intent)
    }
}