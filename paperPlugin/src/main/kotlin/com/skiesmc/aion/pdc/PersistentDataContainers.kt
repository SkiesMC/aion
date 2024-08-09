package com.skiesmc.aion.pdc

import com.skiesmc.aion.key.asBukkit
import io.papermc.paper.persistence.PersistentDataContainerView
import net.kyori.adventure.key.Keyed
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

/** Whether the persistent data container contains the key. */
operator fun PersistentDataContainerView.contains(key: Keyed) = has(key.key().asBukkit())

/** Gets a value from the persistent data container using the [key]. */
operator fun <P, C> PersistentDataContainerView.get(
    key: Keyed,
    type: PersistentDataType<P, C>,
) = get(key.key().asBukkit(), type)

/** Sets a [value] in the persistent data container using the [key]. */
operator fun <P, C : Any> PersistentDataContainer.set(
    key: Keyed,
    type: PersistentDataType<P, C>,
    value: C,
) = set(key.key().asBukkit(), type, value)

/** Gets a [Byte] from the persistent data container. */
fun PersistentDataContainerView.getByte(key: Keyed): Byte? = get(key, PersistentDataTypes.Byte)

/** Sets a [Byte] in the persistent data container. */
fun PersistentDataContainer.setByte(
    key: Keyed,
    value: Byte,
) = set(key, PersistentDataTypes.Byte, value)

/** Gets an [Int] from the persistent data container. */
fun PersistentDataContainerView.getInt(key: Keyed): Int? = get(key, PersistentDataTypes.Int)

/** Sets an [Int] in the persistent data container. */
fun PersistentDataContainer.setInt(
    key: Keyed,
    value: Int,
) = set(key, PersistentDataTypes.Int, value)

/** Gets a [Long] from the persistent data container. */
fun PersistentDataContainerView.getLong(key: Keyed): Long? = get(key, PersistentDataTypes.Long)

/** Sets a [Long] in the persistent data container. */
fun PersistentDataContainer.setLong(
    key: Keyed,
    value: Long,
) = set(key, PersistentDataTypes.Long, value)

/** Gets a [Boolean] from the persistent data container. */
fun PersistentDataContainerView.getBoolean(key: Keyed): Boolean? = get(key, PersistentDataTypes.Boolean)

/** Sets a [Boolean] in the persistent data container. */
fun PersistentDataContainer.setBoolean(
    key: Keyed,
    value: Boolean,
) = set(key, PersistentDataTypes.Boolean, value)

/** Gets a [String] from the persistent data container. */
fun PersistentDataContainerView.getString(key: Keyed): String? = get(key, PersistentDataTypes.String)

/** Sets a [String] in the persistent data container. */
fun PersistentDataContainer.setString(
    key: Keyed,
    value: String,
) = set(key, PersistentDataTypes.String, value)
