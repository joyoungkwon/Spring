package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
