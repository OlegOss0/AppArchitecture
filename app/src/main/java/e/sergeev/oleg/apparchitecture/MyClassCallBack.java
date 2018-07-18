package e.sergeev.oleg.apparchitecture;

/**
 * Created by o.sergeev on 18.07.2018.
 */

public class MyClassCallBack {

    CallBack callBack;

    public interface CallBack{
        void callbacking();
    }

    public void registerCallback(CallBack calback){
        this.callBack = calback;
        doSomthing();
    }

    public void doSomthing(){
        System.out.println("Работаем....");
    }
}
