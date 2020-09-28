package cleanarch.usecases

import cleanarch.adapters.models.UserModel
import cleanarch.adapters.repositories.UserRepository
import cleanarch.domain.entities.UserDomain
import org.springframework.stereotype.Component

@Component
class CreateUser(private val userRepository: UserRepository) {

    operator fun invoke(userDomain: UserDomain): UserDomain {
        val userModel = userRepository.save(UserModel.toModel(userDomain))

        return userModel.toDomain()
    }
}