package kr.mjc.jacob.basics.jdbc.user.raw

import kr.mjc.jacob.basics.jdbc.Web2DataSource
import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.user.User
import java.util.*

fun main() {
  print("List - count page ? ")
  val limit = Limit().apply {
    Scanner(System.`in`).use {
      count = it.nextInt()
      page = it.nextInt()
    }
  }

  Web2DataSource.connection.use { conn ->
    conn.prepareStatement("select userId, email, name from user order by userId desc limit ?,?")
      .use { ps ->
        ps.setInt(1, limit.offset)
        ps.setInt(2, limit.count)
        val userList = mutableListOf<User>()
        ps.executeQuery().use { rs ->
          while (rs.next()) {
            User(
              userId = rs.getInt("userId"),
              email = rs.getString("email"),
              name = rs.getString("name")
            ).let { userList.add(it) }
          }
        }
        println(userList)
      }
  }
}