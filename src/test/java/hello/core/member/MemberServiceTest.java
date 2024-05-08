package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    MemberService  memberService ;

    /*
    * 무조건 다음 코드로 넘어가기전 실행 BeforEach
    * */
    @BeforeEach
    public void beforEach(){
        AppConfig appConfig= new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test

    void join(){
        //given
        Member member = new Member("memberA",1L,Grade.VIP);
        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }



}
