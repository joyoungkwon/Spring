package hello.core.member;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements  MemberRepostitory{

    private static Map<Long,Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(),member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    public static Map<Long, Member> getStore() {
        return store;
    }
}
