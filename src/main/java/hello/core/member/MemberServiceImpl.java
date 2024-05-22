package hello.core.member;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Getter
@Component("service")
public class MemberServiceImpl implements MemberService{


    /*
Test for method
* */
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
}
