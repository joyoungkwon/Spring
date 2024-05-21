package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class SingleTonTest {

    @Test
    public void SingletonTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SignleTonBean.class);
        System.out.println(" find by singleton bean ");
        SignleTonBean bean = ac.getBean(SignleTonBean.class);

        System.out.println(" find by singleton bean ");
        SignleTonBean bean2 = ac.getBean(SignleTonBean.class);


        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);


        Assertions.assertThat(bean).isInstanceOf(SignleTonBean.class); /* instance == class*/
        Assertions.assertThat(bean).isSameAs(bean2);// bean  == bean 2  - t

    }

    @Scope("singleton")
    static class SignleTonBean {
        @PostConstruct
        void init() {
            System.out.println("!Create! SingleTon Bean O");
        }


        @PreDestroy //애플리케이션이 닫힐때만 실행해라.
        void close() {
            System.out.println("!Close! SingleTon Bean X");
        }
    }
}



