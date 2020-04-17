package tw.b2e.sample.service.impl

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Service
import tw.b2e.sample.service.TokenService
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Service
class TokenServiceImpl : TokenService {

    private val algorithm = Algorithm.HMAC256("afjndoifjasdjfioasdjfa")

    override fun generate(ttl_minute: Long) =
            LocalDateTime.now().run {
                JWT.create()
                        .withIssuedAt(Date.from(this.atZone(ZoneId.systemDefault()).toInstant()))
                        .withExpiresAt(Date.from(this.plusMinutes(ttl_minute).atZone(ZoneId.systemDefault()).toInstant()))
                        .sign(algorithm)
            }
}