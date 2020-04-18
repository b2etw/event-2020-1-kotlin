package tw.b2e.sample.controller


import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertEquals
import tw.b2e.sample.pojo.dto.request.UserLoginRequest
import tw.b2e.sample.pojo.entity.UserInfo
import tw.b2e.sample.repository.UserInfoRepository
import java.time.LocalDateTime

@SpringBootTest
class UserDaoTests(
        @Autowired val userApi: UserApi,
        @Autowired val userInfoRepository: UserInfoRepository
) {

    @Test
    fun testLoginSuccess() {
        userInfoRepository.save(UserInfo(null, "Vincent", "123456", LocalDateTime.now(), LocalDateTime.now()))

        val loginResponse = userApi.loginUserV1(UserLoginRequest("Vincent", "123456"))

        assertEquals(loginResponse.message, loginResponse.code, 0)
    }

    @Test
    fun testWrongPassword() {
        userInfoRepository.save(UserInfo(null, "Daniel", "111111", LocalDateTime.now(), LocalDateTime.now()))

        val loginResponse = userApi.loginUserV1(UserLoginRequest("Daniel", "123456"))

        assertEquals(loginResponse.message, loginResponse.code, -100)
    }

    @Test
    fun testUserNotExist() {
        val loginResponse = userApi.loginUserV1(UserLoginRequest("Carlos", "123456"))

        assertEquals(loginResponse.message, loginResponse.code, -101)
    }

}
