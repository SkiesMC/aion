package com.skiesmc.aion.plugin.bootstrap

import io.papermc.paper.plugin.bootstrap.BootstrapContext
import io.papermc.paper.plugin.bootstrap.PluginBootstrap
import io.papermc.paper.plugin.bootstrap.PluginProviderContext
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused", "UnstableApiUsage")
class AionPluginBoostrap : PluginBootstrap {
    override fun bootstrap(context: BootstrapContext) = Unit

    override fun createPlugin(context: PluginProviderContext): JavaPlugin {
        val jarClass = Class.forName(context.configuration.mainClass, true, javaClass.classLoader)
        val pluginClass = jarClass.asSubclass(JavaPlugin::class.java).kotlin
        return checkNotNull(pluginClass.objectInstance) {
            "Plugin class ${pluginClass.qualifiedName} must be an object"
        }
    }
}
