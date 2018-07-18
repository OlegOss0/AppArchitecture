package e.sergeev.oleg.apparchitecture;

import android.widget.Toast;

/**
 * Created by o.sergeev on 18.07.2018.
 */

public class SomeClass implements MyClassCallBack.CallBack {
    @Override
    public void callbacking() {
        System.out.println("Сработал коллбэк из SomeClass");
    }
}
