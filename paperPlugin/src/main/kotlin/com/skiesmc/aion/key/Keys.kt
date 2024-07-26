package com.skiesmc.aion.key

import net.kyori.adventure.key.Key
import org.bukkit.NamespacedKey

/**
 * Converts this Key to a Bukkit [NamespacedKey].
 */
fun Key.asBukkit() = if (this is NamespacedKey) this else NamespacedKey(namespace(), value())
