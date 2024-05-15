package hello.core.singleton;

public class SingletonService {

    public static final SingletonService instance = new SingletonService();
    //
    public static SingletonService getInstance(){return instance;}
    /*C, call x*/
    private SingletonService(){}
    public void Logic(){System.out.println("\"instance\" = " + "instance");}
}
