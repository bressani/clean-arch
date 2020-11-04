package cleanarch.adapters.converters

import cleanarch.adapters.dtos.UserDto
import cleanarch.domain.entities.UserDomain

class DomainToDto {
    companion object {
        fun convert(userDomain: UserDomain): UserDto {
            return UserDto(
                uuid = userDomain.uuid,
                name = userDomain.name
            )
        }
    }
}