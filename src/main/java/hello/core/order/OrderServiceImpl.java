package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixiDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepostitory;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepostitory memberRepostitory;
    private final DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepostitory.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    /*test for method*/
    public MemberRepostitory getMemberRepostitory() {
        return memberRepostitory;
    }
}



/*
 * DIP 정책 위반 추상에만 의존해야하나, 추상(interface와) 구현(impl) 에도 의존 하는 식.
 *
 * */
/*  private final DiscountPolicy discountPolicy = new FixiDiscountPolicy(); // 고정 할인 정책*/
/* private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 정률 할인 정책*/


/*
 * interface(추상)에만 의존하도록 수정
 * */