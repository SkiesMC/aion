package com.skiesmc.aion.pdc

import org.bukkit.persistence.ListPersistentDataTypeProvider
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

/**
 * A collection of persistent data types.
 *
 * @see PersistentDataType
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
object PersistentDataTypes {
    /** A primitive persistent data type for [Byte]s. */
    val Byte: PersistentDataType<Byte, Byte> = PersistentDataType.BYTE

    /** A primitive persistent data type for [ByteArray]s. */
    val ByteArray: PersistentDataType<ByteArray, ByteArray> = PersistentDataType.BYTE_ARRAY

    /** A primitive persistent data type for [Short]s. */
    val Short: PersistentDataType<Short, Short> = PersistentDataType.SHORT

    /** A primitive persistent data type for [Int]s. */
    val Int: PersistentDataType<Int, Int> = PersistentDataType.INTEGER

    /** A primitive persistent data type for [IntArray]s. */
    val IntArray: PersistentDataType<IntArray, IntArray> = PersistentDataType.INTEGER_ARRAY

    /** A primitive persistent data type for [Long]s. */
    val Long: PersistentDataType<Long, Long> = PersistentDataType.LONG

    /** A primitive persistent data type for [LongArray]s. */
    val LongArray: PersistentDataType<LongArray, LongArray> = PersistentDataType.LONG_ARRAY

    /** A primitive persistent data type for [Float]s. */
    val Float: PersistentDataType<Float, Float> = PersistentDataType.FLOAT

    /** A primitive persistent data type for [Double]s. */
    val Double: PersistentDataType<Double, Double> = PersistentDataType.DOUBLE

    /** A persistent data type for [Boolean]s. */
    val Boolean: PersistentDataType<Byte, Boolean> = PersistentDataType.BOOLEAN

    /** A primitive persistent data type for [String]s. */
    val String: PersistentDataType<String, String> = PersistentDataType.STRING

    /** A persistent data type for [PersistentDataContainer]s. */
    val TagContainer: PersistentDataType<PersistentDataContainer, PersistentDataContainer> =
        PersistentDataType.TAG_CONTAINER

    /**
     * A persistent data type provider for [List]s.
     *
     * @see PersistentDataType.LIST
     * @see ListPersistentDataTypeProvider
     */
    val List: ListPersistentDataTypeProvider = PersistentDataType.LIST

    /** A persistent data type for [Key]s. */
    val Key = KeyPersistentDataType

    /** A persistent data type for [UUID]s. */
    val Uuid = UuidPersistentDataType
}
