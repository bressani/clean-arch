package cleanarch.adapters.repositories

import cleanarch.adapters.models.UserModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<UserModel, String>