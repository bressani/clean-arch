package cleanarch.adapters.controllers

import cleanarch.adapters.converters.DomainToDto
import cleanarch.adapters.converters.DtoToDomain
import cleanarch.adapters.dtos.UserDto
import cleanarch.usecases.CreateUser
import cleanarch.usecases.FindUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users/")
class UserController(
    val createUser: CreateUser,
    val findUser: FindUser
) {

    @PostMapping
    fun create(@RequestBody userDto: UserDto): UserDto {
        val user = createUser(DtoToDomain.convert(userDto))

        return DomainToDto.convert(user)
    }

    @GetMapping("/{userUuid}")
    fun find(@PathVariable userUuid: String): UserDto {
        val user = findUser(userUuid)

        return DomainToDto.convert(user)
    }

}