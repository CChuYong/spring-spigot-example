package cchuyong.springspigot_example.service

import cchuyong.springspigot_example.mysql.ExampleEntityRepository
import chuyong.springspigot.synchronize.annotation.Synchronize
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class ExampleService(
    private val exampleEntityRepository: ExampleEntityRepository, //will injected by Spring-Spigot
) {
    @Synchronize // will launched at bukkit-main thread
    fun openInventory(player: Player) {
        val inventory = Bukkit.createInventory(null, 27, "welcome")
        player.openInventory(inventory)
    }

    @Async // will launched at Spring-Async thread
    fun asyncAction() {
        println(Thread.currentThread().name) //will be async thread
    }
}
