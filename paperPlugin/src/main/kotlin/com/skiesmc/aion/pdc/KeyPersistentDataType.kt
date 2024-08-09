package com.skiesmc.aion.pdc

import io.papermc.paper.persistence.PersistentDataContainerView
import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Keyed
import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

/**
 * A persistent data type for [Key]s.
 *
 * It converts keys to and from strings.
 */
object KeyPersistentDataType : PersistentDataType<String, Keyed> {
    override fun getPrimitiveType(): Class<String> = String::class.java

    override fun getComplexType(): Class<Keyed> = Keyed::class.java

    override fun fromPrimitive(
        primitive: String,
        context: PersistentDataAdapterContext,
    ): Key = Key.key(primitive)

    override fun toPrimitive(
        complex: Keyed,
        context: PersistentDataAdapterContext,
    ): String = complex.key().asString()
}

/** Gets a [Key] from the persistent data container. */
fun PersistentDataContainerView.getKey(key: Keyed): Keyed? = get(key, KeyPersistentDataType)

/** Sets a [Key] in the persistent data container. */
fun PersistentDataContainer.setKey(
    key: Keyed,
    value: Keyed,
) = set(key, KeyPersistentDataType, value)
