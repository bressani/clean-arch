package cleanarch.adapters.converters

import cleanarch.fixtures.getRegularUserDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DtoToDomainTest {

    @Test
    fun `test DTO to domain`() {
        val dtoUser = getRegularUserDto()

        val domainUser = DtoToDomain.convert(dtoUser)

        Assertions.assertNull(domainUser.id)
        Assertions.assertNotEquals("185840a0-c51a-4996-b30e-73f0c7f8eca0", domainUser.uuid.toString())
        Assertions.assertEquals("Kakaroto", domainUser.name)
    }
}