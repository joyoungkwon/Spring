package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class MyAnnotationClassTest {


    // breakPoint 17 , F8
    @Test
    void FilterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        AnnotationExmyIncludeClassA bean = ac.getBean(AnnotationExmyIncludeClassA.class);

        //AnnotationExmyEXcludeClassB bean1 = ac.getBean(AnnotationExmyEXcludeClassB.class); <- error code delete

        Assertions.assertThat(bean).isNotNull(); // junit
        org.junit.jupiter.api.Assertions.assertThrows( // Exception -> t
                NoSuchBeanDefinitionException.class, // AnnotationExmyEXcludeClassB.class -> ac.get(this)-> Exception ->
                // Exception == NoSuchBeanDefinitionException -> t
                // else -> f
                // result = t
                () -> ac.getBean(AnnotationExmyEXcludeClassB.class)
        );
        Assertions.assertThat(ac.getBean(AnnotationExmyIncludeClassA.class)).isInstanceOf(AnnotationExmyIncludeClassA.class);
        // 궁금해서 넣어봄

    }
    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type =
                    FilterType.ANNOTATION, classes = myIncludeComponent.class),

            excludeFilters = @ComponentScan.Filter(type =
                    FilterType.ANNOTATION, classes = myExcludeComponent.class)

    )
    static class ComponentFilterAppConfig {

    }
}
