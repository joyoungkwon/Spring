package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepostitory;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonSpringContainerTest {
    @Test 
    @DisplayName("Singleton for SpringContainerTest")
    void SingletonforSrpingContainerTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepostitory memberRepository = ac.getBean("memberRepository", MemberRepostitory.class);

        MemberRepostitory memberRepostitory1 = memberService.getMemberRepostitory();
        MemberRepostitory memberRepostitory2 = orderService.getMemberRepostitory();

        System.out.println("memberRepostitory(memberService) -> " + memberRepostitory1);
        System.out.println("memberRepostitory(orderService)-> " + memberRepostitory2);
        System.out.println("memberRepository -> " + memberRepository);

        Assertions.assertThat(memberRepostitory1).isSameAs(memberRepostitory2);// == t != f
        // t
        /*
        memberRepostitory(memberService) -> hello.core.member.MemoryMemberRepository@764faa6
        memberRepostitory(orderService)-> hello.core.member.MemoryMemberRepository@764faa6
        memberRepository -> hello.core.member.MemoryMemberRepository@764faa6
        instance -> same
        * */
    }

    @Test
    @DisplayName("Configuration SpringContainer deep")
    void ConfigurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
    }
//bean.getClass() = class hello.core.AppConfig$$SpringCGLIB$$0
    /*
    * CGLIB -> 내가만든 AppConfig를 사용하는게 아니라 내가만든 스프링 컨테이너를 사용하지않고
    * 내가만든 @Configuration 어노테이션 을 읽어 바이트 코드조작으로 AppConfig.class를 상속받는
    * AppConfig$$SpringCGLIB$$를 생성하여 읽음
    *
    * */

}
