package cleanarch.fixtures

import cleanarch.domain.entities.UserDomain
import java.util.UUID

fun getRegularUserDomain(
    id: String? = "185840a0",
    uuid: UUID? = UUID.fromString("185840a0-c51a-4996-b30e-73f0c7f8eca0"),
    name: String = "Kakaroto"
): UserDomain {
    return UserDomain(
        id = id,
        uuid = uuid,
        name = name
    )
}

