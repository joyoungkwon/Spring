package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("not spring pureDi container")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();
        MemberService memberService_USER1 = appConfig.memberService();
        MemberService memberService_USER2 = appConfig.memberService();

        /* user1 != user2 -> t
           user1 == user 2 -> f
        * */
        Assertions.assertThat(memberService_USER1).isNotSameAs(memberService_USER2);
    }

    @Test
    @DisplayName("Singleton test")
    void SingletonforEQInctance(){
       SingletonService singletonService1 = SingletonService.getInstance();
       SingletonService singletonService2 = SingletonService.getInstance();
       Assertions.assertThat(singletonService2).isSameAs(singletonService1);
    }

    @Test
    @DisplayName(" spring  container")
    void SpringContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService_USER1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService_USER2 = ac.getBean("memberService",MemberService.class);

        System.out.println("memberService_USER1 = " + memberService_USER1);
        System.out.println("memberService_USER2 = " + memberService_USER2);

        /*
        (Instance) USER1 == USER2 -> T
        (Instance) USER1 != USER2 -> F

        * */
        Assertions.assertThat(memberService_USER1).isSameAs(memberService_USER2);
    }
}
