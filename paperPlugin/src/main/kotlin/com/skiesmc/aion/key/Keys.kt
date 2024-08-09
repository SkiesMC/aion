package com.skiesmc.aion.key

import net.kyori.adventure.key.Key
import org.bukkit.NamespacedKey
import org.bukkit.plugin.Plugin

/**
 * Converts this Key to a Bukkit [NamespacedKey].
 */
fun Key.asBukkit() = if (this is NamespacedKey) this else NamespacedKey(namespace(), value())

/** Creates a new [NamespacedKey] using the provided [value] and the plugin's instance as the namespace. */
fun Plugin.namespacedKey(value: String) = NamespacedKey(this, value)
