package cleanarch.adapters.repositories

import cleanarch.adapters.models.UserModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : MongoRepository<UserModel, String> {

    fun findByUuid(uuid: UUID): UserModel?
}