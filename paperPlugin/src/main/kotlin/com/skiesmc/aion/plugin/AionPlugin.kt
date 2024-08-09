package com.skiesmc.aion.plugin

import org.bukkit.plugin.Plugin

/**
 * Represents a Paper plugin with Kotlin Coroutines support with suspendable lifecycle functions.
 */
interface AionPlugin :
    Plugin,
    AsyncPluginLifecycle
