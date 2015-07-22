package com.example.sebastian.experience22;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SignInFragment extends Fragment {
    private static final String SING_IN_FRAGMENT_TAG = "sign_in_fragment";
    private Button signInBtn;
    private Button cancelBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signInBtn = (Button) view.findViewById(R.id.bn_sign_in);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cancelBtn=(Button)view.findViewById(R.id.bn_cancel1);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFragment();
            }
        });
    }
    private void toggleFragment() {
        Fragment f = getFragmentManager().findFragmentByTag(SING_IN_FRAGMENT_TAG);
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up)
                    .add(R.id.sign_in_fragment, SignInFragment
                                    .instantiate(getActivity(), SignInFragment.class.getName()),
                            SING_IN_FRAGMENT_TAG
                    ).addToBackStack(null).commit();
        }
    }
}
