package cleanarch.adapters.models

import cleanarch.domain.entities.UserDomain
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "users")
class User(
    @Id var id: String? = null,
    var uuid: UUID,
    var name: String

) {

    fun toDomain(): UserDomain {
        return UserDomain(
            id = this.id!!,
            uuid = this.uuid,
            name = this.name
        )
    }

    companion object {
        fun toModel(userDomain: UserDomain): User {
            return User(
                uuid = UUID.randomUUID(),
                name = userDomain.name
            )
        }
    }
}