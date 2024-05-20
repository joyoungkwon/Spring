package hello.core.lifecycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;


   public NetworkClient(){
       System.out.println("Network Connect  " + url);

   }



   public void setUrl(String url){
       this.url = url;
   }

   /*Start Service */
   public void Connect(){
       /*데이터베이스나 , 네트워크 설정 정보 logic */
       System.out.println(" Connect " + url);
   }

   public void call(String message){
       System.out.println(" NetWorkInfo = " + url +" Connect Message ="+ message);
   }

   /*distroy Service*/

    public void disConnect(){
        System.out.println("close");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Connect();
        call("초기화 연결 메세지");

    }

    @Override
    public void destroy() throws Exception {
        disConnect(); // 끝났다고 알려주는 logic
    }
}
