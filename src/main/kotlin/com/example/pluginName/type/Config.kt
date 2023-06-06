package com.example.pluginName.type

import com.example.pluginName.PluginName
import org.bukkit.configuration.file.FileConfiguration

object Config {
    private lateinit var config: FileConfiguration

    val language get() = config.getString("language")

    fun init(pluginName: PluginName) {
        pluginName.saveDefaultConfig()
        config = pluginName.config
        config.options().copyDefaults(true)
        pluginName.saveConfig()
    }
}