package kr.mjc.jacob.spring.springcore.ioc.componentscan

import kr.mjc.jacob.spring.springcore.ioc.beanfactory.TV
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * p.42 SamsungTV.java
 */
@Component
class SamsungTV : TV {

  private val log = LoggerFactory.getLogger(this.javaClass)

  init {
    log.debug("samsungTV 인스턴스 생성됨.")
  }

  override fun powerOn() {
    log.debug("samsungTV power on.")
  }

  override fun powerOff() {
    log.debug("samsungTV power off.")
  }

  override fun volumeUp() {
    log.debug("samsungTV volume up.")
  }

  override fun volumeDown() {
    log.debug("samsungTV volume down.")
  }
}