package tw.b2e.sample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import tw.b2e.sample.pojo.entity.UserInfo

@Repository
interface UserInfoRepository : JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {

    fun findByAccount(account: String): UserInfo?
}
