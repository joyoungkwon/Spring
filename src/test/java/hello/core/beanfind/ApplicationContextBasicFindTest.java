package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    /*AnnotationConfigApplicationContext 클래스 생성 인스턴스 ac 생성 -> ac 는 AppConfig.Class 를 사용하여
    * AppConfig.Class의 Annotation 을 기반으로 설정정보를 읽어와서 ac의 ApplicationContext를 구성*/
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("find by bean name")
    void findBeanByName(){
        /*interface MemberService 의 설정정보를 ac 라는 Context를 이용하여 조회, 기본적으로 interface를 조회하면
        * impl 구현체가 검색됌.*/
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        /*assertThat -> import static org.assertj.core.api.Assertions.*; . isInstanceOf () 제공된 객체가 제공된 클래스의 인스턴스인지 확인.
        * 맞으면 t 틀리면 f */
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /*이름으로 bean을 찾지 않고 type으로 찾기*/
    @Test
    @DisplayName("no name find by for type bean")
    void findBeanByType(){
        /*MemberService.class 의 설정 정보를 ac로 읽고 MemberService 클래스의 저장*/
        MemberService memberService = ac.getBean( MemberService.class);
        /*assertThat -> import static org.assertj.core.api.Assertions.*; . isInstanceOf () 제공된 객체가 제공된 클래스의 인스턴스인지 확인.
         * 맞으면 t 틀리면 f */
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /*추상 클래스 를 구현체로 찾기*/
    @Test
    @DisplayName("implement by bean")
    void findBeanByImpl(){
      /*  MemberService memberService = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
      *
      * */
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    /*NoSuchBeanDefinitionException: No bean named 'xxxx' available Exception*/
    /*f test code
    * 내가 설정한 Exception 인 경우 t
    * 예외 처리 코드.
    * */
    @Test
    @DisplayName("find by Bean Error")
    void findBeanByNameX(){
        /*ac.getBean("xxxx",MemberService.class);*/

        /*다른 점 AssertThrows -> import 하는 게 import static org.junit.jupiter.api.Assertions.*;
        *
        * */
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
        /*(예상가능)예외 던짐 람다 표현식,()-> 문제를 일으킬 의심이 가는 동작 메서드 (ac.getBean(name"xxxx",MemberService))
        * 내가만든 xxxx라는 이름을 가진 Bean은 존재하지않음 -> 던지기로 예외가 발생한다면 t 예외가 발생하지 않는다면 f
        * */
    }
}
