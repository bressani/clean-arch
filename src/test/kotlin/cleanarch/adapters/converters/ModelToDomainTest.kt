package cleanarch.adapters.converters

import cleanarch.fixtures.getRegularUserModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ModelToDomainTest{

    @Test
    fun `test to domain`() {
        val modelUser = getRegularUserModel()

        val domainUser = ModelToDomain.convert(modelUser)

        Assertions.assertEquals("185840a0", domainUser.id)
        Assertions.assertEquals("185840a0-c51a-4996-b30e-73f0c7f8eca0", domainUser.uuid.toString())
        Assertions.assertEquals("Kakaroto", domainUser.name)
    }
}