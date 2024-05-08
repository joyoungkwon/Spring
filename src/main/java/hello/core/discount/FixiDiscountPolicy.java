package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixiDiscountPolicy  implements  DiscountPolicy{

    private int discountFixAmount = 1000; // 천원할인

    /*DiscountPolicy interface method override*/
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
