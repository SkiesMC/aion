package com.skiesmc.aion.item

import com.skiesmc.aion.AionCorePlugin
import com.skiesmc.aion.key.namespacedKey
import com.skiesmc.aion.pdc.getKey
import com.skiesmc.aion.pdc.setKey
import net.kyori.adventure.key.Keyed
import org.bukkit.inventory.ItemStack

internal object AionItemProviderRegistry : ItemProviderRegistry {
    private val itemIdKey = AionCorePlugin.namespacedKey("item_id")
    private val providers = mutableMapOf<Keyed, ItemStackProvider>()

    override fun register(
        key: Keyed,
        provider: ItemStackProvider,
    ): Boolean =
        if (key in providers) {
            false
        } else {
            providers[key] = {
                provider().also {
                    it.persistData { setKey(itemIdKey, key) }
                }
            }
            true
        }

    override fun unregister(key: Keyed): Boolean = providers.remove(key) != null

    override fun get(key: Keyed): ItemStackProvider? = providers[key]

    override fun contains(key: Keyed): Boolean = key in providers

    override fun match(itemStack: ItemStack): Keyed? {
        val key = itemStack.itemMeta?.persistentDataContainer?.getKey(itemIdKey) ?: return null
        return if (key in providers) key else null
    }
}
