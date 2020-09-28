package cleanarch.usecases

import cleanarch.adapters.models.UserModel
import cleanarch.adapters.repositories.UserRepository
import cleanarch.fixtures.getRegularUser
import cleanarch.fixtures.getRegularUserDomain
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CreateUserTest {

    @MockK
    lateinit var userRepository: UserRepository

    @InjectMockKs
    lateinit var createUser: CreateUser

    @SpyK
    var userMock = getRegularUser(
        id = "58590522",
        name = "name"
    )

    @BeforeEach
    fun setUp() {
        every { userRepository.save(any<UserModel>()) } returns userMock
        every { userMock.toDomain() } returns
            getRegularUserDomain(
                id = "22b9ef53",
                name = "name2"
            )
    }

    @Test
    fun `test invoke`() {
        val createdUser = createUser(
            getRegularUserDomain(
                id = "58590522",
                name = "name"
            )
        )

        assertEquals("22b9ef53", createdUser.id)
        assertEquals("name2", createdUser.name)
    }
}