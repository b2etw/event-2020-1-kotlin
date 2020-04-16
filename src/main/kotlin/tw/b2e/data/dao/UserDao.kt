package tw.b2e.data.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import tw.b2e.data.entity.User

@Repository
interface UserDao : JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findByAccount(account: String): User?
}
