package tw.b2e.sample.controller

import org.springframework.web.bind.annotation.PostMapping
import tw.b2e.sample.pojo.dto.request.UserLoginRequest
import tw.b2e.sample.pojo.dto.response.UserLoginResponse

interface UserApi {

    @PostMapping("/v1/user/login")
    fun loginUserV1(userLoginRequest: UserLoginRequest): UserLoginResponse
}
