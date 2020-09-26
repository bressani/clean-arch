package cleanarch.usecases.ports

import cleanarch.adapters.models.User

interface UserRepositoryPort {

    fun create(user: User): User
}