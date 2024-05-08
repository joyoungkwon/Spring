package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
    * @return 할인 대상금액
    * ex) 얼마에 대한 할인
    * */
    int discount(Member member , int price);
}
