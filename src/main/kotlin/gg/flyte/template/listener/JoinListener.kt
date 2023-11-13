package gg.flyte.template.listener

import gg.flyte.twilight.event.event
import gg.flyte.twilight.scheduler.delay
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinListener : Listener {

    init {
        event<PlayerJoinEvent> {
            delay {
                player.sendMessage(
                    Component.text("Hello, ${player.name}! You joined 1 tick ago!")
                        .color(NamedTextColor.RED)
                )
            }
        }

        event<PlayerQuitEvent>(EventPriority.HIGHEST, true) {
            Bukkit.broadcast(
                Component.text("Goodbye, ${player.name}!")
                    .color(NamedTextColor.RED)
            )
        }
    }

}