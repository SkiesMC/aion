package com.skiesmc.aion.item

import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataContainer

/** Persists data in the ItemStack's persistent data container using the given [block]. */
fun ItemStack.persistData(block: PersistentDataContainer.() -> Unit) {
    editMeta {
        block(it.persistentDataContainer)
    }
}

/** Copies the ItemStack and applies the given [builder]. */
fun ItemStack.copy(builder: ItemStack.() -> Unit = {}) = clone().apply(builder)

/** Returns the ItemStack if it is not empty, otherwise null. */
fun ItemStack.nullable() = if (isEmpty) null else this

/** Returns the ItemStack if it is not empty, otherwise an empty ItemStack. */
fun ItemStack?.orEmpty() = this ?: ItemStack.empty()
