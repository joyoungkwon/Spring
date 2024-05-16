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
}
