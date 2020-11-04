package cleanarch.adapters.converters

import cleanarch.adapters.models.UserModel
import cleanarch.domain.entities.UserDomain

class ModelToDomain {
    companion object {
        fun convert(userModel: UserModel): UserDomain {
            return UserDomain(
                id = userModel.id!!,
                uuid = userModel.uuid,
                name = userModel.name
            )
        }
    }
}