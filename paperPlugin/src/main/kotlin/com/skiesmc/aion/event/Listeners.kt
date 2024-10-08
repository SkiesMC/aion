package com.skiesmc.aion.event

import com.skiesmc.aion.plugin.firstJavaPlugin
import com.skiesmc.aion.server.PaperServer
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin

/**
 * Registers the listener to receive events from the Bukkit plugin manager.
 *
 * @param plugin the plugin to register the listener with (defaults to the calling plugin)
 * @see org.bukkit.plugin.PluginManager.registerEvents
 */
fun Listener.registerAll(plugin: Plugin = firstJavaPlugin()) = PaperServer.pluginManager.registerEvents(this, plugin)

/**
 * Registers a listener for a specific event type with custom event execution.
 *
 * @param E the event type to listen for
 * @param plugin the plugin that owns the listener (defaults to the calling plugin)
 * @param priority the priority of the listener (defaults to [EventPriority.NORMAL])
 * @param ignoreCancelled specifies if cancelled events should be ignored (defaults to false)
 * @param executor the function to execute when the event is called
 * @return the registered listener
 */
inline fun <reified E : Event> Listener.register(
    plugin: Plugin = firstJavaPlugin(),
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false,
    noinline executor: (Listener, E) -> Unit,
) = apply {
    PaperServer.pluginManager.registerEvent(
        E::class.java,
        this,
        priority,
        { listener, event -> (event as? E)?.let { executor(listener, it) } },
        plugin,
        ignoreCancelled,
    )
}

/**
 * Unregisters this listener from all event handler lists.
 *
 * @see HandlerList.unregisterAll
 */
fun Listener.unregisterAll() = HandlerList.unregisterAll(this)

/**
 * Creates a listener and registers it to receive event [E] from the Bukkit plugin manager.
 *
 * @param E the event type to listen for
 * @param plugin the plugin that owns the listener (defaults to the calling plugin)
 * @param priority the priority of the listener (defaults to [EventPriority.NORMAL])
 * @param ignoreCancelled specifies if cancelled events should be ignored (defaults to false)
 * @param action the callback to execute when the event occurs
 * @return the registered listener
 */
inline fun <reified E : Event> listen(
    plugin: Plugin = firstJavaPlugin(),
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false,
    crossinline action: (E) -> Unit,
) = EventListener<E> { event -> action(event) }.also {
    it.register(plugin, priority, ignoreCancelled)
}
