package com.mapzen.erasermap.model

import com.mapzen.erasermap.BuildConfig
import com.mapzen.erasermap.EraserMapApplication
import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito

class ApiKeysTest {
    val application = EraserMapApplication()
    val apiKeys = ApiKeys.Companion.sharedInstance(application)

    @Test fun shouldNotBeNull() {
        assertThat(apiKeys).isNotNull()
    }

    @Test(expected = IllegalArgumentException::class) fun shouldNotAcceptEmptyTilesKey() {
        PowerMockito.mockStatic(BuildConfig::class.java)
        Mockito.doReturn(null).`when`(BuildConfig.VECTOR_TILE_API_KEY)
        ApiKeys.Companion.sharedInstance(application)
    }

    @Test(expected = IllegalArgumentException::class) fun shouldNotAcceptEmptySearchKey() {
        PowerMockito.mockStatic(BuildConfig::class.java)
        Mockito.doReturn(null).`when`(BuildConfig.PELIAS_API_KEY)
        ApiKeys.Companion.sharedInstance(application)
    }

    @Test(expected = IllegalArgumentException::class) fun shouldNotAcceptEmptyRoutingKey() {
        PowerMockito.mockStatic(BuildConfig::class.java)
        Mockito.doReturn(null).`when`(BuildConfig.VALHALLA_API_KEY)
        ApiKeys.Companion.sharedInstance(application)
    }
}
