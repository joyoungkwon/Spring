package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements MemberService{



    private final MemberRepostitory memberRepostitory;

    @Autowired
    public MemberServiceImpl(MemberRepostitory memberRepostitory) {
        this.memberRepostitory = memberRepostitory;
    }

    @Override
    public void join(Member member) {
        memberRepostitory.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepostitory.findById(memberId);
    }
/*
Test for method
* */
    public MemberRepostitory getMemberRepostitory() {
        return memberRepostitory;
    }
}
