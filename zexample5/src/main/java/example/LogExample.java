package example;

import lombok.extern.slf4j.Slf4j;

// SLF4J 를 이용하여 로깅 객체를 만들어 주입하라
// SLF4J 를 사용하면 객체를 생성하여 println 대신 사용한다.
// 롬복에게 SLF4J 객체를 만들어서 넣어달라고 요청한다.
@Slf4j
public class LogExample {
  public static void main(String[] args) {
    System.out.println("Always");
    
    log.trace("1Lv");
    log.debug("2Lv");
    log.info("3Lv");
    log.warn("4Lv");
    log.error("5Lv");
  }
}
