package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {


    @Test
    void PrototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);


        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);


    }

    @Test
    void singletonClientUserPrototypeBean() {
        AnnotationConfigApplicationContext
                ac =
                new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);

    }

    @Scope("singleton")
    static class ClientBean {
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBean;

        @Autowired
        ClientBean(ObjectProvider<PrototypeBean> prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            PrototypeBean object = prototypeBean.getObject();
            object.addCount();
            int count = object.getCount();
            return count;
        }
    }


    @Getter
    @Scope("prototype")
    static class PrototypeBean {
        /*int filed*/
        private int count = 0;

        /*증가 메서드*/
        public void addCount() {
            count++;
        }

        //bean 초기화 , 생성 알림 메서드
        @PostConstruct
        void init() {
            System.out.println("PrototypeBean.init()" + this);// this 현제객체정보
        }

        // bean 종료 메서드
        @PreDestroy
        void destroy() {
            System.out.println(" PrototypeBean.destroy()" + this);
        }

    }
}
