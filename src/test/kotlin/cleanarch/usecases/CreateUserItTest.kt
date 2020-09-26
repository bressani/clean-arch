package cleanarch.usecases

import cleanarch.adapters.models.User
import cleanarch.adapters.repositories.UserRepository
import cleanarch.fixtures.getRegularUserDomain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate

@SpringBootTest
class CreateUserItTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    lateinit var createUser: CreateUser

    @BeforeEach
    fun setUp() {
        createUser = CreateUser(userRepository)
    }

    @Test
    fun `create user`() {
        val createdUser = createUser(getRegularUserDomain())

        val userFromDb = mongoTemplate.findById(createdUser.id!!, User::class.java)

        assertNotNull(createdUser.id)
        assertEquals("Kakaroto", createdUser.name)

        assertEquals(createdUser.id, userFromDb?.id)
        assertEquals("Kakaroto", userFromDb?.name)
    }
}