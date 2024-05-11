package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("find of Full Bean Info")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // Cycle : beanDefinitionNames of zeroIndex~lastIndex = (object) String beanDefinitionName 에 하나씩 인젝션 후 pln
        for (String beanDefinitionName : beanDefinitionNames) {

            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName+"object /t" + bean);
        }

    }


    /* Role = Role_APPLICATION :직접 등록한 애플리케이션 빈
      Role = ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈*/

    /*bean 저장소에는 배열처럼 0번쨰 방(key) 의 내가 지정한 BeanName(value) 상수값이 자동으로 지정된다.
    그래서 getRole()이라는 int 반환 타입으로 key 값을 순회하며 ROLE_APPLICATION (내가 생성한) 의 빈 생성 상수 값(KEY)과 비교하여
    순회한 int (key) 값과 내가만든 빈은 상수로 생성된 (KEY)값이 같은지를 비교 하고 같으면 오브젝트 타입으로 Bean의 정보를 저장시키고 zero
    에서 last index 까지 순회하며 출력한다.*/


    @Test
    @DisplayName("Application Bean Info")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName+" object = " + bean);
            }

        }

    }
}
