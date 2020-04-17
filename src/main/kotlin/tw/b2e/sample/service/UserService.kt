package tw.b2e.sample.service

import tw.b2e.sample.pojo.dto.request.UserLoginRequest
import tw.b2e.sample.pojo.dto.response.UserLoginResponse

interface UserService {

    fun login(userLoginRequest: UserLoginRequest): UserLoginResponse
}
