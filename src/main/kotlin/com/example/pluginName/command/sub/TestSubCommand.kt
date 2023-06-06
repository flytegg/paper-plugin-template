package com.example.pluginName.command.sub

import com.example.pluginName.PluginName
import com.example.pluginName.command.SubCommand
import com.example.pluginName.type.language.Message
import com.example.pluginName.type.language.Message.deserialize
import com.example.pluginName.type.language.Message.fillInVariables
import org.bukkit.command.CommandSender

class TestSubCommand(private val pluginName: PluginName) : SubCommand() {
    override fun execute(sender: CommandSender, args: Array<out String>) {
        if (args.size <= 1) {
            sender.sendMessage(Message.illegalArguments)
            return
        }

        sender.sendMessage(Message.exampleMessage.fillInVariables(arrayOf(sender.name, sender.isOp.toString())))
        sender.sendMessage("<aqua>Your favorite component letter is: ${args[1]}".deserialize())

    }

    override fun tabComplete(sender: CommandSender, args: Array<out String>): MutableList<String>? {
        if (args.size != 2) return null

        return mutableListOf<String>().apply {
            add("a")
            add("b")
            add("c")
        }
    }
}
