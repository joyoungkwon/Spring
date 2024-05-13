package hello.core.beanfind;


import hello.core.member.MemberRepostitory;
import hello.core.member.MemoryMemberRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("Exception Test")
    void findByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,()-> ac.getBean(MemberRepostitory.class));
        /*.
        MemberRepostitory bean = ac.getBean(MemberRepostitory.class);
        NoUniqueBeanDefinitionException-> type으로 Bean을 조회 했더니
        * 하나만 존재하지않는다 라는 예외
        * */
    }

    /*
    test1 code 의 Exception 잡기 test코드
    발생한 예외 유니크하지 않음 -> Bean의 이름을 붙혀 검색하기.(내가 찾고자 하는 Bean의 이름)
    * */
    @Test
    @DisplayName("Exception Throws catch Test ")
    void findBeanByName(){
        /*MemberRepostitory 인스턴스 에 MemberRepostitory class 의 구성정보를 ac로 끌어어오기 이때 어노테이션 @Bean으로 지정된
        * 설정정보 중에 memberRepository1 이라 이름 붙힌 @Bean을 호출*/
        MemberRepostitory memberRepository = ac.getBean("memberRepository1", MemberRepostitory.class);
        /* 호출하여 instance 한 타입을 assertThat.isInstanceOf(내가만든 appConfig.class) 의 참조 객체가 맞는지 확인
        * 맞으면 t 틀리면 f
        */
        assertThat(memberRepository).isInstanceOf(MemberRepostitory.class);
        //결과 t
    }

    /*모든 특정 type search */
    @Test
    @DisplayName("Search by bean eq type instance")
    void findAllBeanByType(){
        /*AnnotationConfigApplicationContext instance 의 getBeanOfType 를 활용하여 beanOftype instance 의 저장
        * 이때 반환값은 key 와 value -> bean은 생성될때 bean저장소에 key 와 value 로 생성되고 저장되기 때문 그래서 Map을 이용하여
        * key와 value로 받기*/
        Map<String, MemberRepostitory> beansOfType = ac.getBeansOfType(MemberRepostitory.class);
        /*반복자 안의 map의 keySet 을 이용하여 key 값 obj -> 저장*/
        for (String key : beansOfType.keySet()) {
            if (beansOfType.equals(ac.getBeansOfType(MemberRepostitory.class))) // 하나씩 뽑아올때마다
                // 저장한 type이 MemberRepostitory.class에서 뽑아온
                //타입과 일치하면 soutv
            System.out.println("key =" +key +"value =" + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        /*assertTaht-> baenofType의.size-> isEqualto(int type)
        * s-> t,  f->f
        * r->t
        * */
        assertThat(beansOfType.size()).isEqualTo(2);
        
    }




    /*
     * static 장점 클래스안에서 클래스 를 썻다는거만 애 안에서만 쓰겟다라는뜻
     * 정적. test code를 위한 새로운 AppConfig 설정
     * */
    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepostitory memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepostitory memberRepository2(){
            return new MemoryMemberRepository();
        }
    }


}
