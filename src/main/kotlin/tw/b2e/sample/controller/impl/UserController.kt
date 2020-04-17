package tw.b2e.sample.controller.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import tw.b2e.sample.controller.UserApi
import tw.b2e.sample.pojo.dto.request.UserLoginRequest
import tw.b2e.sample.service.UserService

@RestController
class UserController(
        @Autowired val userService: UserService
) : UserApi {

    override fun loginUserV1(userLoginRequest: UserLoginRequest) = userService.login(userLoginRequest)
}