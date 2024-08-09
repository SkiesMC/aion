package com.skiesmc.aion.pdc

import io.papermc.paper.persistence.PersistentDataContainerView
import net.kyori.adventure.key.Keyed
import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType
import java.nio.ByteBuffer
import java.util.UUID

/**
 * A persistent data type for [UUID]s.
 *
 * It converts UUIDs to and from 16-byte arrays.
 */
object UuidPersistentDataType : PersistentDataType<ByteArray, UUID> {
    private const val UUID_BYTE_SIZE = 16

    override fun getPrimitiveType(): Class<ByteArray> = ByteArray::class.java

    override fun getComplexType(): Class<UUID> = UUID::class.java

    override fun fromPrimitive(
        primitive: ByteArray,
        context: PersistentDataAdapterContext,
    ): UUID {
        val buffer = ByteBuffer.wrap(primitive)
        return UUID(buffer.long, buffer.long)
    }

    override fun toPrimitive(
        complex: UUID,
        context: PersistentDataAdapterContext,
    ): ByteArray {
        val buffer = ByteBuffer.wrap(ByteArray(UUID_BYTE_SIZE))
        buffer.putLong(complex.mostSignificantBits)
        buffer.putLong(complex.leastSignificantBits)
        return buffer.array()
    }
}

/** Gets a [UUID] from the persistent data container. */
fun PersistentDataContainerView.getUuid(key: Keyed): UUID? = get(key, UuidPersistentDataType)

/** Sets a [UUID] in the persistent data container. */
fun PersistentDataContainer.setUuid(
    key: Keyed,
    value: UUID,
) = set(key, UuidPersistentDataType, value)
