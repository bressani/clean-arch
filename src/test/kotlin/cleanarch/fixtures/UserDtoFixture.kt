package cleanarch.fixtures

import cleanarch.adapters.dtos.UserDto
import java.util.UUID

fun getRegularUserDto(
    uuid: UUID = UUID.fromString("185840a0-c51a-4996-b30e-73f0c7f8eca0"),
    name: String = "Kakaroto"
): UserDto {
    return UserDto(
        uuid = uuid,
        name = name
    )
}