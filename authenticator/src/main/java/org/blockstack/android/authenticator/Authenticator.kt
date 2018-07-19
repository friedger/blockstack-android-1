package org.blockstack.android.authenticator

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.content.Context
import android.content.Intent
import android.os.Bundle

class Authenticator(private val context: Context) : AbstractAccountAuthenticator(context) {
    override fun getAuthTokenLabel(authTokenType: String?): String? {
        return null
    }

    override fun confirmCredentials(response: AccountAuthenticatorResponse?, account: Account?, options: Bundle?): Bundle {
        val intent = Intent(context, AuthenticatorActivity::class.java).putExtra(AuthenticatorActivity.CONFIRM, true)
        return Bundle().apply { this.putParcelable(android.accounts.AccountManager.KEY_INTENT, intent) }
    }

    override fun updateCredentials(response: AccountAuthenticatorResponse?, account: Account?, authTokenType: String?, options: Bundle?): Bundle? {
        val intent = Intent(context, AuthenticatorActivity::class.java).putExtra(AuthenticatorActivity.UPDATE, true)
        return Bundle().apply { this.putParcelable(android.accounts.AccountManager.KEY_INTENT, intent) }
    }

    override fun getAuthToken(response: AccountAuthenticatorResponse?, account: Account?, authTokenType: String?, options: Bundle?): Bundle {

    }

    override fun hasFeatures(response: AccountAuthenticatorResponse?, account: Account?, features: Array<out String>?): Bundle {
        return Bundle(1).apply { putBoolean(android.accounts.AccountManager.KEY_BOOLEAN_RESULT, false) }
    }

    override fun editProperties(response: AccountAuthenticatorResponse?, accountType: String?): Bundle {
        val intent = Intent(context, AuthenticatorActivity::class.java).putExtra(AuthenticatorActivity.EDIT, true)
        return Bundle().apply { this.putParcelable(android.accounts.AccountManager.KEY_INTENT, intent) }
    }

    override fun addAccount(response: AccountAuthenticatorResponse?, accountType: String?, authTokenType: String?, requiredFeatures: Array<out String>?, options: Bundle?): Bundle {
        val intent = Intent(context, AuthenticatorActivity::class.java).putExtra(AuthenticatorActivity.ADD, true)
        return Bundle().apply { this.putParcelable(android.accounts.AccountManager.KEY_INTENT, intent) }
    }

}