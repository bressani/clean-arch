package cleanarch.adapters.converters

import cleanarch.fixtures.getRegularUserDomain
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DomainToDtoTest {

    @Test
    fun `test domain to model`() {
        val userDomain = getRegularUserDomain()

        val dtoUser = DomainToDto.convert(userDomain)

        Assertions.assertEquals("185840a0-c51a-4996-b30e-73f0c7f8eca0", dtoUser.uuid.toString())
        Assertions.assertEquals("Kakaroto", dtoUser.name)
    }
}