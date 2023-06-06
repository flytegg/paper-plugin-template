package com.example.pluginName

import com.example.pluginName.command.TemplateCommand
import com.example.pluginName.type.Config
import com.example.pluginName.listener.JoinListener
import com.example.pluginName.type.language.Message
import org.bukkit.plugin.java.JavaPlugin

class PluginName : JavaPlugin() {

    override fun onEnable() {
        Config.init(this)
        Message.init(this)

        val command = TemplateCommand(this)
        getCommand("template")!!.setExecutor(command)
        getCommand("template")!!.tabCompleter = command

        server.pluginManager.registerEvents(JoinListener(this), this)
    }
}