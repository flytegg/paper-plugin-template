package com.example.pluginName.listener

import com.example.pluginName.PluginName
import com.example.pluginName.type.language.Message
import com.example.pluginName.type.language.Message.fillInVariables
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinListener(private val pluginName: PluginName) : Listener {

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        e.player.apply { sendMessage(Message.exampleMessage.fillInVariables(arrayOf(this.name, this.isOp.toString()))) }
    }
}