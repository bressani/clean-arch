package cleanarch.fixtures

import cleanarch.adapters.models.User
import java.util.UUID

fun getRegularUser(
    id: String = "185840a0",
    uuid: UUID = UUID.fromString("185840a0-c51a-4996-b30e-73f0c7f8eca0"),
    name: String = "Kakaroto"
): User {
    return User(
        id = id,
        uuid = uuid,
        name = name
    )
}