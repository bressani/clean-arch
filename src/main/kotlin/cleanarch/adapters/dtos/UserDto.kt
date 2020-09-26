package cleanarch.adapters.dtos

import cleanarch.domain.entities.UserDomain
import java.util.UUID

class UserDto(
    var uuid: UUID? = null,
    var name: String
) {
    fun toDomain(): UserDomain {
        return UserDomain(name = this.name)
    }

    companion object {
        fun toDto(userDomain: UserDomain): UserDto {
            return UserDto(
                uuid = userDomain.uuid,
                name = userDomain.name
            )
        }
    }
}

