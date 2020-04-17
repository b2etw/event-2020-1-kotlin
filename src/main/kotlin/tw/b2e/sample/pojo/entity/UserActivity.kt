package tw.b2e.sample.pojo.entity

import tw.b2e.sample.pojo.enum.ActivityType
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class UserActivity(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,

        val uid: Long,

        val activity: ActivityType,

        val createTime: LocalDateTime,

        val updateTime: LocalDateTime
)
