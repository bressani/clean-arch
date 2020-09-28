package cleanarch.usecases

import cleanarch.adapters.repositories.UserRepository
import cleanarch.domain.entities.UserDomain
import org.springframework.stereotype.Component

@Component
class FindUser(private val userRepository: UserRepository) {

    operator fun invoke(userUuid: String): UserDomain {
        val userModel = userRepository.findById(userUuid)

        return userModel.get().toDomain()
    }
}