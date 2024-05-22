package hello.core.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

/*
* 순서: 컨테이너에 http request 요청시 하나씩 request scope 하나씩 생성 처리 후 소멸
* 1 @PostConstruct 으로 첫번쨰 생성 uuid = UUID.RANDOM으로 UUID 하나씩 생성
* 2 public void log() 메서드 실행
* 3 @PreDestroy 로 마지막 close () 메서드 실행
* requestUrl은 생성 시점을 알수 없어서 외부에서 주입.(조립)
* */

@Component // 스캔
@Scope(value="request",proxyMode = ScopedProxyMode.TARGET_CLASS)
// http 가 요청 될떄 요청당 하나씩 생기고 요청이 종료되면 소멸 되는 범위.(lifeCycle)
public class MyLogger {
    private String uuid;
    private String RequestURL;

    public void setRequestURL(String requestURL) {
        RequestURL = requestURL;
    }

    public void log (String message){

        System.out.println("["+uuid+"]" + "["+RequestURL+"]" + " : "+ message );
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString(); // 생성 새로운거 생성하는거임 그냥
        System.out.println("["+uuid+"]" + "request scope bean create : " + this );
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid +"]" + "request scope bean close " + this );

    }
}
