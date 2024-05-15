package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Bean matad data Info")

    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition definition = ac.getBeanDefinition(beanDefinitionName);
            if(definition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("definition = " + definition+
                "Beandefinition =" + beanDefinitionName +"\n"
                );
            }
        }

    }
}
