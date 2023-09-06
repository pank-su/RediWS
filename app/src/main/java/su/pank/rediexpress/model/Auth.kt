package su.pank.rediexpress.model

data class Auth(
    val fullName: String,
    val phoneNumber: String,
    val emailAddress: String,
    val password: String
) {
}