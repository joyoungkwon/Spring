package hello.core.order;

public class Order {

    /**
     * memberId (나중에 db랑 연결하는 primaryKey인듯)
     * 상품 이름(itemName)
     * 상품 가격(itemPrice)
     * discountPrice
     */
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;
    /**
     *
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @param discountPrice
     */

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    /*caculater method*/
    public int calculaterPrice(){

        return itemPrice - discountPrice;

    }

    /**
     * getter , setter
     * */

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
