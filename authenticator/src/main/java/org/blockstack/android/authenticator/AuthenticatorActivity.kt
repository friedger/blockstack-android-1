package org.blockstack.android.authenticator

import android.accounts.AccountAuthenticatorActivity

class AuthenticatorActivity : AccountAuthenticatorActivity() {

    companion object {
        const val EDIT = "edit"
        const val ADD = "add"
        const val UPDATE = "update"
        const val CONFIRM = "confirm"
    }
}