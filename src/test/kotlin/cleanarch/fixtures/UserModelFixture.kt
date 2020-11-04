package cleanarch.fixtures

import cleanarch.adapters.models.UserModel
import java.util.UUID

fun getRegularUserModel(
    id: String = "185840a0",
    uuid: UUID = UUID.fromString("185840a0-c51a-4996-b30e-73f0c7f8eca0"),
    name: String = "Kakaroto"
): UserModel {
    return UserModel(
        id = id,
        uuid = uuid,
        name = name
    )
}