package tw.b2e.sample.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tw.b2e.sample.pojo.dto.request.UserLoginRequest
import tw.b2e.sample.pojo.dto.response.UserLoginResponse
import tw.b2e.sample.pojo.entity.UserActivity
import tw.b2e.sample.pojo.enum.ActivityType
import tw.b2e.sample.pojo.enum.LoginResult
import tw.b2e.sample.repository.UserActivityRepository
import tw.b2e.sample.repository.UserInfoRepository
import tw.b2e.sample.service.TokenService
import tw.b2e.sample.service.UserService
import java.time.LocalDateTime

@Service
class UserServiceImpl(
        @Autowired val tokenService: TokenService,
        @Autowired val userInfoRepository: UserInfoRepository,
        @Autowired val userActivityRepository: UserActivityRepository
) : UserService {

    override fun login(userLoginRequest: UserLoginRequest) =
            userInfoRepository.findByAccount(userLoginRequest.account)?.run {
                if (userLoginRequest.password == this.password) {
                    userActivityRepository.save(UserActivity(
                            null,
                            this.id!!,
                            ActivityType.LOGIN,
                            LocalDateTime.now(),
                            LocalDateTime.now())
                    )

                    UserLoginResponse(LoginResult.SUCCESS.code, LoginResult.SUCCESS.message, tokenService.generate(30))
                } else {
                    UserLoginResponse(LoginResult.WRONG_PASSWORD.code, LoginResult.WRONG_PASSWORD.message, "")
                }
            } ?: UserLoginResponse(LoginResult.USER_NOT_EXIST.code, LoginResult.USER_NOT_EXIST.message, "")
}
