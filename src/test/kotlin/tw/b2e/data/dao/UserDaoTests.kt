package tw.b2e.data.dao

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertEquals
import tw.b2e.data.entity.User
import java.time.LocalDateTime

@SpringBootTest
class UserDaoTests(
        @Autowired val userDao: UserDao
) {

    @Test
    fun contextLoads() {
        val user = User(null, "vincent", "123456", LocalDateTime.now(), LocalDateTime.now())
        userDao.save(user)

        val findByAccount1 = userDao.findByAccount("vincent")
        assertEquals("account equals", "vincent", findByAccount1!!.account)

        userDao.save(findByAccount1.copy(password = "111111"))
        val findByAccount2 = userDao.findByAccount("vincent")
        assertEquals("password equals", "111111", findByAccount2!!.password)
    }

}
