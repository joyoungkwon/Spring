package hello.core.member;

public class MemberServiceImpl implements MemberService{



    private final MemberRepostitory memberRepostitory = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepostitory.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepostitory.findById(memberId);
    }
}
