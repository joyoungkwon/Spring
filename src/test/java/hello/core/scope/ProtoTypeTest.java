package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class ProtoTypeTest {


    @Test
    void ProtoTypeFindByBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        System.out.println(" find by bean protoType "  );
        ProtoTypeBean bean = ac.getBean(ProtoTypeBean.class);

        System.out.println(" find by bean protoType "  );
        ProtoTypeBean bean2 = ac.getBean(ProtoTypeBean.class);

        System.out.println("bean = " + bean);
        System.out.println("bean = " + bean2);

        Assertions.assertThat(bean).isNotSameAs(bean2);

        ac.close();

    }
    @Scope("prototype")
    static class ProtoTypeBean{

        @PostConstruct
        void init(){
            System.out.println("!Create! ProtoType!  O");
        }

        @PreDestroy
        void Destroy(){
            System.out.println("!Destroy! ProtoType! X");
        }

    }
}
