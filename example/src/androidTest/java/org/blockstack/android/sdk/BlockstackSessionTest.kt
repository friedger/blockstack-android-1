package org.blockstack.android.sdk

import android.support.test.InstrumentationRegistry
import android.support.test.annotation.UiThreadTest
import org.hamcrest.Matchers
import org.junit.Test

import org.junit.Assert.*
import java.net.URI
import java.util.concurrent.CountDownLatch

class BlockstackSessionTest {

    private lateinit var blockstackSession: BlockstackSession
    private val latch = CountDownLatch(1)


    @Test
    @UiThreadTest
    fun loadUserData() {
        val appDomain = URI.create("http://example.com")
        val redirectUri = URI.create("http://example.com/redirect")
        val manifestUri = URI.create("http://example.com/manifest.json")
        var userData: UserData? = null

        blockstackSession = BlockstackSession(InstrumentationRegistry.getTargetContext(), appDomain, redirectUri, manifestUri, emptyArray()
        ) {
            blockstackSession.loadUserData { data ->
                userData = data
                latch.countDown()
            }
        }

        latch.await();
        assertThat(userData, Matchers.nullValue())
    }
}