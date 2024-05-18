package hello.core.autowried;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWriedTest {


    @Test
    void AutoWriedTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);



    }


    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
            // print x

        }

        @Autowired()
        public void setNoBean2(@Nullable Member noBean2) {
            String obj;
            System.out.println("noBean2 = " + noBean2);
            // print null

        }

        @Autowired()
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
            // print Optional.empty
        }
    }
}

