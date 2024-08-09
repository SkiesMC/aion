package com.skiesmc.aion.item

import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataContainer

/** Persists data in the ItemStack's persistent data container using the given [block]. */
fun ItemStack.persistData(block: PersistentDataContainer.() -> Unit) {
    editMeta {
        block(it.persistentDataContainer)
    }
}
