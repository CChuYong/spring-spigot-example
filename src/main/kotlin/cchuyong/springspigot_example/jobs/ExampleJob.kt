package cchuyong.springspigot_example.jobs

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ExampleJob {
    @Scheduled(fixedDelay = 100L, initialDelay = 100L)
    fun tickEvery100ms() {
        //Will fired every 100ms
        println("Hello World!")
    }

    @Scheduled(cron = "0 0 0 * * *")
    fun tickEveryDay() {
        //Will fired every day 00:00:00
        println("Hello World!")
    }
}
