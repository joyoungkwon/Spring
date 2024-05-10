package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixiDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepostitory;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
* AppConfig -> 나의 어플리케이션을 전체를 설정하고 구성한다는 뜻
* 기존 코드와 다르게 직접적인 객체 를 직접 캐스팅 하는 방식에서 DI 방식으로 수정
* (Dependency Injection)
*
* */
public class AppConfig {

    public MemberService memberService(){
        return  new MemberServiceImpl(memberRepository());
    }

    private MemberRepostitory memberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService(){

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
       /* return new FixiDiscountPolicy();*/
        return new RateDiscountPolicy();
    }


}
