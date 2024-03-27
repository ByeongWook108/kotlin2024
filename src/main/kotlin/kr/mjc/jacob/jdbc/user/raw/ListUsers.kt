package kr.mjc.jacob.jdbc.user.raw

import kr.mjc.jacob.jdbc.DataSourceFactory
import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.user.User
import kr.mjc.jacob.jdbc.user.mapUser
import java.util.*

fun main() {
  print("List - pageNumber pageSize ? ")
  val page = Scanner(System.`in`).use { Page(it.nextInt(), it.nextInt()) }

  val sql =
    "select id, username, first_name, date_joined from user order by id desc limit ?,?"
  val userList = mutableListOf<User>()
  DataSourceFactory.dataSource.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setInt(1, page.offset)
      ps.setInt(2, page.size)

      ps.executeQuery().use { rs ->
        while (rs.next()) {
          val user = mapUser(rs)
          userList.add(user)
        }
      }
    }
  }
  userList.forEach(::println)
}