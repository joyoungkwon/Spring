package hello.core.member;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();

        Member member = new Member("memberA", 1L, Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("newmember = " + member.getName());
        System.out.println("find member = " + findmember.getName());

    }
}
