package cleanarch.domain.entities

import java.util.UUID

data class UserDomain(
    var id: String? = null,
    var uuid: UUID? = null,
    var name: String
)