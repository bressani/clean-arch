package cleanarch.domain.exceptions

class UserNotFoundException(message: String = "User not found"): RuntimeException(message)