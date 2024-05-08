package hello.core.member;

public interface MemberRepostitory {

    void save (Member member);

    Member findById(Long memberId);
}
