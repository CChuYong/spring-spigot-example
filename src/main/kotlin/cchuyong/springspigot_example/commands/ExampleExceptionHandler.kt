package cchuyong.springspigot_example.commands

import chuyong.springspigot.command.annotation.CommandAdvice
import chuyong.springspigot.command.annotation.CommandExceptionHandler
import org.bukkit.command.CommandSender

@CommandAdvice
class ExampleExceptionHandler {
    @CommandExceptionHandler(RuntimeException::class)
    fun handleException(sender: CommandSender, ex: RuntimeException) {
        //will fired on RuntimeException occured during command execution.
        sender.sendMessage("Error occured: ${ex.message}")
    }
}
