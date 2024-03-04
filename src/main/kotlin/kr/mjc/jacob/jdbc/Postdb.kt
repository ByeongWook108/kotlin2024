package kr.mjc.jacob.jdbc

import org.mariadb.jdbc.MariaDbDataSource
import java.util.*

object Postdb : MariaDbDataSource() {

  init {
    val props = Properties()
    props.load(this.javaClass.getResourceAsStream("/application.properties"))
    url = props.getProperty("db.url")
  }
}