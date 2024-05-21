package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void BeanLifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig2.class);
        NetworkClient2 bean = ac.getBean(NetworkClient2.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig2 {

        /* @Bean(initMethod = "init" , destroyMethod = "close")* 메서드 활용방식/

         */
        @Bean
        public NetworkClient2 LifeCycleConfig2() {
            NetworkClient2 networkClient2 = new NetworkClient2();
            networkClient2.setUrl("http://wwww.naver.com");
            return networkClient2;
        }

    }
}
