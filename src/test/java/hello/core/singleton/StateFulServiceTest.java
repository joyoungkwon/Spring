package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    @DisplayName("test")

    void statefulServiceSingleton(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        int  memberAPrice = stateFulService1.order("memberA",10000);
        int memberBPrice = stateFulService2.order("memberB",20000);

        
        org.assertj.core.api.Assertions.assertThat(memberAPrice).isEqualTo(10000);
        System.out.println("memberAPrice = " + memberAPrice);
    }

    static class TestConfig {

        @Bean
        public StateFulService stateFulService(){
            return  new StateFulService();
        }
    }

}