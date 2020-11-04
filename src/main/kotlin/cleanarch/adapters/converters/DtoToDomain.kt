package cleanarch.adapters.converters

import cleanarch.adapters.dtos.UserDto
import cleanarch.domain.entities.UserDomain

class DtoToDomain {
    companion object {
        fun convert(userDto: UserDto): UserDomain {
            return UserDomain(name = userDto.name)
        }
    }
}