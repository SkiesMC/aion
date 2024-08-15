package com.skiesmc.aion.plugin.bootstrap

import io.papermc.paper.plugin.bootstrap.BootstrapContext
import io.papermc.paper.plugin.bootstrap.PluginBootstrap
import io.papermc.paper.plugin.bootstrap.PluginProviderContext
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused", "UnstableApiUsage")
class KotlinObjectPluginBoostrap : PluginBootstrap {
    override fun bootstrap(context: BootstrapContext) = Unit

    override fun createPlugin(context: PluginProviderContext): JavaPlugin {
        val mainClass = context.configuration.mainClass
        val jarClass =
            try {
                Class.forName(mainClass, true, javaClass.classLoader)
            } catch (e: ClassNotFoundException) {
                throw IllegalArgumentException("Cannot find main class $mainClass", e)
            }
        val pluginClass =
            try {
                jarClass.asSubclass(JavaPlugin::class.java).kotlin
            } catch (e: ClassCastException) {
                throw IllegalArgumentException("Main class $mainClass is not extends JavaPlugin", e)
            }
        return checkNotNull(pluginClass.objectInstance) {
            "Plugin class $mainClass must be an object"
        }
    }
}
