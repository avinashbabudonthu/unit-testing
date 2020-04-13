package com.springboot.spock.controller

import com.springboot.spock.service.AppService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AppControllerTest extends Specification {

    @SpringBean
    AppService appService = Stub() {
        findNumbers() >> Arrays.asList(7, 8, 9, 10)
    }

    @Autowired
    AppController appController

    void "find numbers test"() {
        when:
        println appController
        List<Integer> list = appController.findNumbers()
        println list
        then:
        [7, 8, 9, 10] == list
    }
}
