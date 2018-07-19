package org.blockstack.android.authenticator

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AuthenticatorService: Service() {
    private val mAuthenticator: Authenticator

    override fun onBind(intent: Intent?): IBinder {
        return mAuthenticator.IBinder;
    }

}