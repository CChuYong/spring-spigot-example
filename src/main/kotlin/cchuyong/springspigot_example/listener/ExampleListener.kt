package cchuyong.springspigot_example.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.springframework.stereotype.Component

@Component
class ExampleListener: Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.player.sendMessage("Welcome to Spigot-Spring!")
    }
}
