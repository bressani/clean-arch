package cleanarch.adapters.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "users")
class UserModel(
    @Id var id: String? = null,
    var uuid: UUID,
    var name: String
)