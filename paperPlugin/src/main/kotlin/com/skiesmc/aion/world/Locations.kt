package com.skiesmc.aion.world

import org.bukkit.Location
import org.bukkit.World

/** Creates a new location with the specified values. */
fun Location(
    world: World? = null,
    x: Double = 0.0,
    y: Double = 0.0,
    z: Double = 0.0,
    yaw: Float = 0.0f,
    pitch: Float = 0.0f,
) = Location(world, x, y, z, yaw, pitch)

/** Copies this location and applies the specified changes. */
fun Location.copy(
    world: World? = this.world,
    x: Double = this.x,
    y: Double = this.y,
    z: Double = this.z,
    yaw: Float = this.yaw,
    pitch: Float = this.pitch,
) = copy {
    this.world = world
    this.x = x
    this.y = y
    this.z = z
    this.yaw = yaw
    this.pitch = pitch
}

/** Copies this location and applies the [builder] to the copied object. */
fun Location.copy(builder: Location.() -> Unit) = clone().apply(builder)

/** Adds the specified values to this location. */
fun Location.add(
    x: Double = 0.0,
    y: Double = 0.0,
    z: Double = 0.0,
    yaw: Float = 0.0f,
    pitch: Float = 0.0f,
) = add(x, y, z).apply {
    this.yaw += yaw
    this.pitch += pitch
}

/** Subtracts the specified values from this location. */
fun Location.subtract(
    x: Double = 0.0,
    y: Double = 0.0,
    z: Double = 0.0,
    yaw: Float = 0.0f,
    pitch: Float = 0.0f,
) = subtract(x, y, z).apply {
    this.yaw -= yaw
    this.pitch -= pitch
}

/** Sets the specified values to this location. */
fun Location.set(
    x: Double = this.x,
    y: Double = this.y,
    z: Double = this.z,
    yaw: Float = this.yaw,
    pitch: Float = this.pitch,
) = apply {
    this.x = x
    this.y = y
    this.z = z
    this.yaw = yaw
    this.pitch = pitch
}
