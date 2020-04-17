package tw.b2e.sample.controller


import org.junit.jupiter.api.BeforeEach
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

    @BeforeEach
    fun beforeEach() {
        userInfoRepository.save(UserInfo(null, "Vincent", "123456", LocalDateTime.now(), LocalDateTime.now()))
    }

    @Test
    fun test() {
        val loginResponse = userApi.loginUserV1(UserLoginRequest("Vincent", "123456"))

        assertEquals("password equals", loginResponse.code, 0)
    }

}
