package com.skiesmc.aion.event

import org.bukkit.event.Cancellable

/** Sets the cancellation state of this event. */
fun Cancellable.cancel(cancelled: Boolean = true) {
    isCancelled = cancelled
}
