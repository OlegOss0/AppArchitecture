package e.sergeev.oleg.apparchitecture;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvUserId = (TextView)getView().findViewById(R.id.tvUserID);
        tvUserInfo = (TextView)getView().findViewById(R.id.tvUserID);
        String userId = getArguments().getString(UID_KEY);
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
}
