package hello.core;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class lombokTest {
    private String name;
    private int age;


    public static void main(String[] args) {
        lombokTest lombokTest = new lombokTest();
        lombokTest.setAge(15);
        lombokTest.setName("YeoungKwon");


        System.out.println("lombokTest.getName() = " + lombokTest.getName());
        System.out.println("lombokTest.getName() = " + lombokTest.getAge());

    }
}
