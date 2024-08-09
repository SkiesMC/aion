package com.skiesmc.aion.plugin

import com.skiesmc.aion.coroutines.mcCoroutine
import kotlinx.coroutines.runBlocking
import org.bukkit.plugin.java.JavaPlugin

/**
 * Base class for Typhon Kotlin plugins.
 * This class provides the functionality for a Paper plugin with Kotlin Coroutines support.
 */
abstract class AionKotlinPlugin :
    JavaPlugin(),
    AionPlugin {
    override suspend fun onLoadAsync() = Unit

    override suspend fun onEnableAsync() = Unit

    override suspend fun onDisableAsync() = Unit

    final override fun onLoad() {
        runBlocking {
            onLoadAsync()
        }
    }

    final override fun onEnable() {
        mcCoroutine.getCoroutineSession(this).isManipulatedServerHeartBeatEnabled = true
        runBlocking {
            onEnableAsync()
        }
        server.servicesManager
        mcCoroutine.getCoroutineSession(this).isManipulatedServerHeartBeatEnabled = false
    }

    final override fun onDisable() {
        runBlocking {
            onDisableAsync()
        }
    }
}
