package kr.mjc.jacob.jdbc.post.raw

import kr.mjc.jacob.jdbc.DataSourceFactory
import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.post.Post
import kr.mjc.jacob.jdbc.post.mapPost
import java.util.*

fun main() {
  print("List - pageNumber pageSize ? ")
  val page = Scanner(System.`in`).use { Page(it.nextInt(), it.nextInt()) }

  val sql = """
    select id, title, user_id, first_name, pub_date, last_modified
    from post order by id desc limit ?,?""".trimIndent()

  val postList = mutableListOf<Post>()
  DataSourceFactory.dataSource.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setInt(1, page.offset)
      ps.setInt(2, page.size)

      ps.executeQuery().use { rs ->
        while (rs.next()) {
          val post = mapPost(rs)
          postList.add(post)
        }
      }
    }
  }
  postList.forEach(::println)
}