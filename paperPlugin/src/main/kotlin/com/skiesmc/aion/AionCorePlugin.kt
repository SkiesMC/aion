package com.skiesmc.aion

import org.bukkit.plugin.java.JavaPlugin
import xyz.xenondevs.invui.InvUI

object AionCorePlugin : JavaPlugin() {
    override fun onEnable() {
        InvUI.getInstance().setPlugin(this)
    }
}
