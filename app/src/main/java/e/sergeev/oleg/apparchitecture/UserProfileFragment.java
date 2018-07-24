package e.sergeev.oleg.apparchitecture;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by o.sergeev on 18.07.2018.
 */

public class UserProfileFragment extends Fragment {
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;
    TextView tvUserId;
    TextView tvUserInfo;
    String userId;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvUserId = (TextView)getView().findViewById(R.id.tvUserID);
        tvUserInfo = (TextView)getView().findViewById(R.id.tvUserID);
        if (savedInstanceState != null){
            userId = getArguments().getString(UID_KEY);
        }else {
            userId = Integer.toString(0 + (int) + Math.random() * 100);
        }
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(userId);

        viewModel.getUser().observe(this, user -> {
            tvUserId.setText(userId);
            tvUserInfo.setText(user.name + ", " + user.lastName);
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_profile_fragmen, container, false);
    }

    public void onBtnClicked(String str){
        tvUserId.setText(str);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(UID_KEY, userId);
    }
}
