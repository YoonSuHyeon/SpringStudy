package hello.core.lifrcycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {
    private String url;
    
    public NetworkClient(){
        System.out.println("생서자 호출, url = " + url);

    }
    public void setUrl(String url){
        this.url = url;
    }
    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " +url);
    }

    public void call (String message){
        System.out.println("call :" +url + "message = "+ message);
    }

    //서비스 종료시 호출
    public void disConnect(){
        System.out.println("close" + url);
    }


    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disConnect();
    }
//    @Override
//    public void afterPropertiesSet() throws Exception { //의존관계 주입이 끝나면 실행 시킨다.
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disConnect();
//    }
}
