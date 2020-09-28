package cleanarch.adapters.models

import cleanarch.fixtures.getRegularUser
import cleanarch.fixtures.getRegularUserDomain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class UserModelTest {

    @Test
    fun `test to domain`() {
        val user = getRegularUser()

        val domainUser = user.toDomain()

        assertEquals("185840a0", domainUser.id)
        assertEquals("185840a0-c51a-4996-b30e-73f0c7f8eca0", domainUser.uuid.toString())
        assertEquals("Kakaroto", domainUser.name)
    }

    @Test
    fun `test to model`() {
        val user = getRegularUserDomain()

        val modelUser = UserModel.toModel(user)

        assertNull(modelUser.id)
        assertNotEquals("185840a0-c51a-4996-b30e-73f0c7f8eca0", modelUser.uuid.toString())
        assertEquals("Kakaroto", modelUser.name)
    }

}