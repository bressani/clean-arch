package cleanarch.adapters.controllers

import cleanarch.adapters.dtos.UserDto
import cleanarch.usecases.CreateUser
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users/")
class UserController(
    val createUser: CreateUser
) {

    @PostMapping
    fun create(@RequestBody userDto: UserDto): UserDto {
        val user = createUser(userDto.toDomain())

        return UserDto.toDto(user)
    }

}