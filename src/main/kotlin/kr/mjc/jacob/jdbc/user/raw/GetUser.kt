package kr.mjc.jacob.jdbc.user.raw

import kr.mjc.jacob.jdbc.DataSourceFactory
import kr.mjc.jacob.jdbc.user.mapUser
import java.util.*

fun main() {
  print("Get - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }

  val sql =
    "select id, username, password, first_name, date_joined from user where id=?"

  DataSourceFactory.dataSource.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setInt(1, id)
      ps.executeQuery().use { rs ->
        if (rs.next()) {
          val user = mapUser(rs)
          println(user)
        } else {
          println("사용자 없음")
        }
      }
    }
  }
}
