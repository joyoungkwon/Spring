package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
/*
        AppConfig appConfig= new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/

        // 어플리케이션 객체 를 통해 메인 컨테이너를 불러오겠다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // applicationContext 객체의 .getBean메서드를 활용하여 appConfig 메인 스프링 컨테이너 의
        // 등록된 bean 중에 이름을 memberService 라 붙혀있는 bean을 끌어오겠다
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // applicationContext 객체의 .getBean메서드를 활용하여 appConfig 메인 스프링 컨테이너 의
        // 등록된 bean 중에 이름을 orderService  라 붙혀있는 bean을 끌어오겠다
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member("memberA",memberId, Grade.VIP);
        memberService.join(member);

       Order order =  orderService.createOrder(memberId,"itemA",20000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculaterPrice());
    }
}
