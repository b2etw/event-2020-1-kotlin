package tw.b2e.sample.service

interface TokenService {

    fun generate(ttl_minute: Long): String
}