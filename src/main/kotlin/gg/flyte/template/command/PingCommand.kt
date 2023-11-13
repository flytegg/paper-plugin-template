package gg.flyte.template.command

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Default
import revxrsal.commands.annotation.Optional
import revxrsal.commands.annotation.Range

class PingCommand {

    @Command("ping")
    fun pingCommand(
        sender: Audience,
        @Optional @Default("1") @Range(min = 1.0, max = 10.0) times: Int
    ) {
        for (i in 1..times) {
            sender.sendMessage(
                Component.text("Pong!")
                    .color(NamedTextColor.LIGHT_PURPLE)
                    .decorate(TextDecoration.UNDERLINED)
            )
        }
    }

}