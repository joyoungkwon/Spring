package hello.core.lifecycle;


public class NetworkClient2 {

    private String url;


    public NetworkClient2() {
        System.out.println("Network Connect  " + url);

    }


    public void setUrl(String url) {
        this.url = url;
    }

    /*Start Service */
    public void Connect() {
        /*데이터베이스나 , 네트워크 설정 정보 logic */
        System.out.println(" Connect " + url);
    }

    public void call(String message) {
        System.out.println(" NetWorkInfo = " + url + " Connect Message =" + message);
    }

    /*distroy Service*/

    public void disConnect() {
        System.out.println("close");
    }



    public void init()  {
        System.out.println(" init 호출 메서드 성공");
        Connect();
        call("초기화 연결 메세지");

    }


    public void close()  {
        System.out.println(" close 호출 성공 자원해제." );
        disConnect(); // 끝났다고 알려주는 logic
    }
}
