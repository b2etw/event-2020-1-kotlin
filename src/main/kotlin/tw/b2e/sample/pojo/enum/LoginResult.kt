package tw.b2e.sample.pojo.enum

enum class LoginResult(val code: Int, val message: String) {

    SUCCESS(0, "SUCCESS"),
    WRONG_PASSWORD(-100, "WRONG PASSWORD"),
    USER_NOT_EXIST(-101, "USER NOT EXIST")

}