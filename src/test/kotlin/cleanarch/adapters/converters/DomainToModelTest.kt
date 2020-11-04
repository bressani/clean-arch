package cleanarch.adapters.converters

import cleanarch.fixtures.getRegularUserDomain
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DomainToModelTest {

    @Test
    fun `test domain to model`() {
        val domainUser = getRegularUserDomain()

        val modelUser = DomainToModel.convert(domainUser)

        Assertions.assertNull(modelUser.id)
        Assertions.assertNotEquals("185840a0-c51a-4996-b30e-73f0c7f8eca0", modelUser.uuid.toString())
        Assertions.assertEquals("Kakaroto", modelUser.name)
    }
}