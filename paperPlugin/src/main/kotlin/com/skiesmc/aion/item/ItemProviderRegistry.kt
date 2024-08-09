package com.skiesmc.aion.item

import net.kyori.adventure.key.Keyed
import org.bukkit.inventory.ItemStack

/** A function that provides an [ItemStack]. */
typealias ItemStackProvider = () -> ItemStack

/**
 * This interface represents a registry for item providers.
 *
 * Item providers are responsible for supplying item stacks for specific key values.
 */
interface ItemProviderRegistry {
    /**
     * Registers a new item [provider] with the specified [key].
     *
     * @return Returns true if the registration was successful, false if the key is already registered.
     */
    fun register(
        key: Keyed,
        provider: ItemStackProvider,
    ): Boolean

    /**
     * Unregisters the item provider with the specified [key].
     *
     * @return Returns true if the remove was successful, false if the key is not registered.
     */
    fun unregister(key: Keyed): Boolean

    /**
     * Gets the item provider with the specified [key].
     *
     * @return Returns the item provider if it exists, null otherwise.
     */
    operator fun get(key: Keyed): ItemStackProvider?

    /**
     * Checks if the registry contains an item provider with the specified [key].
     *
     * @return Returns true if the registry contains the key, false otherwise.
     */
    operator fun contains(key: Keyed): Boolean

    /**
     * Matches the specified [itemStack] to a key.
     *
     * This method is used to determine if the item stack was created by an item provider in this registry.
     * May return a key even if the item stack was not created by an item provider in this registry.
     *
     * @return Returns the key if the item stack is matched, null otherwise.
     */
    fun match(itemStack: ItemStack): Keyed?

    /**
     * The default item provider registry.
     *
     * Item provided by this registry will have a key associated with them.
     * This key used to identify the item provider that created the item.
     */
    companion object : ItemProviderRegistry by AionItemProviderRegistry
}
