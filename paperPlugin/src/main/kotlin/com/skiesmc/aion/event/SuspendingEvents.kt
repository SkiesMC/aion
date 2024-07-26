package com.skiesmc.aion.event

import com.github.shynixn.mccoroutine.folia.EventExecutionType
import com.github.shynixn.mccoroutine.folia.callSuspendingEvent
import com.skiesmc.aion.plugin.firstJavaPlugin
import com.skiesmc.aion.server.PaperServer
import org.bukkit.event.Event
import org.bukkit.plugin.Plugin

/**
 * Calls an event with the given details.
 * Allows awaiting the completion of suspending event listeners.
 *
 * @param plugin Plugin plugin.
 * @param executionType Allows specifying how suspend receivers are executed.
 * @return Collection of await-able jobs. This job list may be empty if no suspending listener
 * was called. Each job instance represents an await-able job for each method being called in each suspending listener.
 * For awaiting use callSuspendingEvent(...).joinAll().
 *
 * @see org.bukkit.plugin.PluginManager.callSuspendingEvent
 */
fun Event.callSuspending(
    plugin: Plugin = firstJavaPlugin(),
    executionType: EventExecutionType = EventExecutionType.Concurrent,
) = PaperServer.pluginManager.callSuspendingEvent(this, plugin, executionType)
