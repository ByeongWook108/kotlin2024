package kr.mjc.rachel.basics.jdbc.article;

import kr.mjc.rachel.basics.jdbc.DaoFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class AddArticle {
  public static void main(String[] args) {
    ArticleDao articleDao = DaoFactory.getArticleDao();
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("title// : ");
    String title = scanner.next();
    System.out.print("content// : ");
    String content = scanner.next();
    scanner.close();

    Article article = new Article();
    article.setTitle(title);
    article.setContent(content);
    article.setUserId(1);
    article.setName("Jacob");
    articleDao.addArticle(article);

    log.debug("저장 완료");
  }
}
