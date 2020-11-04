package cleanarch.usecases

import cleanarch.adapters.converters.DomainToModel
import cleanarch.adapters.converters.ModelToDomain
import cleanarch.adapters.repositories.UserRepository
import cleanarch.domain.entities.UserDomain
import org.springframework.stereotype.Component

@Component
class CreateUser(private val userRepository: UserRepository) {

    operator fun invoke(userDomain: UserDomain): UserDomain {
        val userModel = userRepository.save(DomainToModel.convert(userDomain))

        return ModelToDomain.convert(userModel)
    }
}