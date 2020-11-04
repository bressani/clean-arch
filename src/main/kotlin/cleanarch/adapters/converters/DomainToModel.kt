package cleanarch.adapters.converters

import cleanarch.adapters.models.UserModel
import cleanarch.domain.entities.UserDomain
import java.util.UUID

class DomainToModel {
    companion object {
        fun convert(userDomain: UserDomain): UserModel {
            return UserModel(
                uuid = UUID.randomUUID(),
                name = userDomain.name
            )
        }
    }
}