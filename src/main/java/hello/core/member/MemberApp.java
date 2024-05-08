package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
       MemberService memberService= appConfig.memberService();

        Member member = new Member("memberA", 1L, Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("newmember = " + member.getName());
        System.out.println("find member = " + findmember.getName());

    }
}
