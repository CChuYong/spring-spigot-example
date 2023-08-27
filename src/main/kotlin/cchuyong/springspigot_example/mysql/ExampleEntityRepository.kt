package cchuyong.springspigot_example.mysql

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExampleEntityRepository: JpaRepository<ExampleEntity, UUID> {
    fun findByPlayerUsername(playerUsername: String): ExampleEntity? //will find by username column
}
