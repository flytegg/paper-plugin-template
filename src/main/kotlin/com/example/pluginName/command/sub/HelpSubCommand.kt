package com.example.pluginName.command.sub

import com.example.pluginName.command.SubCommand
import com.example.pluginName.command.SubCommandType
import com.example.pluginName.type.language.Message.colorize
import net.kyori.adventure.text.Component
import org.bukkit.command.CommandSender

class HelpSubCommand : SubCommand() {
    override fun execute(sender: CommandSender, args: Array<out String>) {
        for (command in SubCommandType.values()) {
            sender.sendMessage(Component.text("<aqua>${command.name} -> ${command.usage}").colorize())
        }
    }

    override fun tabComplete(sender: CommandSender, args: Array<out String>): MutableList<String>? {
        return null
    }
}