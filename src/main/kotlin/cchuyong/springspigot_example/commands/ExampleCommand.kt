package cchuyong.springspigot_example.commands

import cchuyong.springspigot_example.service.ExampleService
import chuyong.springspigot.command.annotation.CommandController
import chuyong.springspigot.command.annotation.CommandMapping
import chuyong.springspigot.external.economy.EconomyService
import chuyong.springspigot.scheduler.SchedulerService
import org.bukkit.entity.Player
import org.springframework.scheduling.annotation.Async
import java.math.BigDecimal

@CommandController
@CommandMapping("example", child = "child")
class ExampleCommand(
    private val exampleService: ExampleService,
    private val schedulerService: SchedulerService,
    private val economyService: EconomyService,
) {
    //On command "/example child"
    @CommandMapping
    fun example(player: Player) {
        economyService.deposit(player, BigDecimal(100))
        player.sendMessage("You got 100 dollar!!")
    }

    @CommandMapping("baby")
    fun baby(player: Player) {
        schedulerService.scheduleSyncDelayedTask {
            println("I'm scheduled!!")
        }
    }

    @Async
    @CommandMapping("baby", child = "cute")
    fun babyCute(player: Player) {
        exampleService.openInventory(player) //will be executed bukkit-main thread
        exampleService.asyncAction() //will be executed async thread
    }

    @CommandMapping("exception")
    fun exception(player: Player) {
        throw RuntimeException("Simple Exception!!")
    }
}
