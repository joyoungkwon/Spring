package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepostitory;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
* AppConfig -> 나의 어플리케이션을 전체를 설정하고 구성한다는 뜻
* 기존 코드와 다르게 직접적인 객체 를 직접 캐스팅 하는 방식에서 DI 방식으로 수정
* (Dependency Injection)
*
* */

@Configuration // 설정 정보 , 어플리케이션의 어떤 설정정보 등을 뜻하는 어노테이션
public class AppConfig {



    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return  new MemberServiceImpl(memberRepository());
    }
    @Primary
    @Bean
    public MemberRepostitory  memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository ();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
       /* return new FixiDiscountPolicy();*/
        return new RateDiscountPolicy();
    }

    /*
    * SingletonSprigContainerTest를 실행시켰을때 기대값
    * 스프링 컨테이너에서 bean의 실행결과 순서는 보장하지않지만
    * memberRepository는 3번 호출이 되는걸 기대.
    * 결과는 1번씩만 호출 같은 인스턴스를 쓰고있다는걸 확인.
    * */


}
