package cleanarch.usecases

import cleanarch.adapters.converters.ModelToDomain
import cleanarch.adapters.repositories.UserRepository
import cleanarch.domain.entities.UserDomain
import cleanarch.domain.exceptions.UserNotFoundException
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FindUser(private val userRepository: UserRepository) {

    operator fun invoke(userUuid: String): UserDomain {
        val userModel = userRepository.findByUuid(UUID.fromString(userUuid)) ?: throw UserNotFoundException()

        return ModelToDomain.convert(userModel)
    }
}