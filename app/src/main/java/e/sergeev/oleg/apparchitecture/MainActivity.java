package e.sergeev.oleg.apparchitecture;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by o.sergeev on 16.07.2018.
 */

public class MainActivity extends FragmentActivity{


    MyClassCallBack myClassCallBack = new MyClassCallBack();
    BlankFragment blankFragment;
    SomeClass someClass;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blankFragment = new BlankFragment();
        someClass = new SomeClass();
        myClassCallBack.registerCallback(blankFragment);
        myClassCallBack.registerCallback(someClass);

        UserProfileFragment userProfileFragment = new UserProfileFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.container, userProfileFragment);
        fragmentTransaction.commit();

        Button btnY = (Button) findViewById(R.id.btnYes);
        Button btnN = (Button) findViewById(R.id.btnNo);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnYes:
                        blankFragment.onBtnClicked("YES");
                        someClass.callbacking();
                        break;
                    case R.id.btnNo:
                        blankFragment.onBtnClicked("NO");
                        someClass.callbacking();
                        break;
                }
            }
        };
        btnN.setOnClickListener(onClickListener);
        btnY.setOnClickListener(onClickListener);

    }
}
