package cchuyong.springspigot_example.mysql

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.UUID

@Entity(name = "player_entity")
data class ExampleEntity(
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "player_uuid")
    val playerUniqueId: UUID,

    @Column(name = "player_username")
    val playerUsername: String,
)
