package cleanarch.usecases

import cleanarch.adapters.converters.ModelToDomain
import cleanarch.adapters.models.UserModel
import cleanarch.adapters.repositories.UserRepository
import cleanarch.fixtures.getRegularUserDomain
import cleanarch.fixtures.getRegularUserModel
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
class CreateUserTest {

    @MockK
    lateinit var userRepository: UserRepository

    @InjectMockKs
    lateinit var createUser: CreateUser

    @BeforeEach
    fun setUp() {
        var userModelMock = getRegularUserModel(
            id = "58590522",
            name = "name"
        )
        every { userRepository.save(any<UserModel>()) } returns userModelMock

        mockkObject(ModelToDomain)
        every { ModelToDomain.convert(userModelMock) } returns
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
        assertEquals(UUID.fromString("185840a0-c51a-4996-b30e-73f0c7f8eca0"), createdUser.uuid)
        assertEquals("name2", createdUser.name)
    }
}