package cleanarch.usecases.ports

import cleanarch.adapters.models.UserModel

interface UserRepositoryPort {

    fun create(userModel: UserModel): UserModel
}