package kr.mjc.rachel.spring.ioc.beanfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * p.45 BeanFactory.java 수정
 */
public class BeanFactory {

  Map<String, Object> map = new HashMap<>();

  /**
   * Default constructor<br>
   * SamsungTV 인스턴스와 LgTV 인스턴스를 생성해서 보관한다.
   */
  public BeanFactory() {
    map.put("samsung", new SamsungTV());
    map.put("lg", new LgTV());
  }

  public Object getBean(String name) {
    return map.get(name);
  }
}
