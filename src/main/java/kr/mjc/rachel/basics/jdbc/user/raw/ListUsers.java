package kr.mjc.rachel.basics.jdbc.user.raw;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;
import kr.mjc.rachel.basics.jdbc.user.User;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 회원 목록<br>
 * count와 page를 입력받아서 해당 목록을 가져온다.
 */
@Slf4j
public class ListUsers {

  public static void main(String[] args) {
    DataSource dataSource = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("List - count page : ");
    // 입력
    int count = scanner.nextInt();  // 목록의 갯수
    int page = scanner.nextInt(); // 페이지
    scanner.close();

    int offset = (page - 1) * count;  // 목록의 시작 시점
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(
            "select userId, email, name from user order by userId desc limit ?,?")) {
      ps.setInt(1, offset);
      ps.setInt(2, count);
      ResultSet rs = ps.executeQuery();
      List<User> userList = new ArrayList<>();
      while (rs.next()) {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        userList.add(user);
      }
      log.debug(userList.toString());
    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
