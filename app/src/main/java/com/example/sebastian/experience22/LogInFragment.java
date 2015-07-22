package com.example.sebastian.experience22;


import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
public class LogInFragment extends Fragment {
    private static final String SING_IN_FRAGMENT_TAG = "sign_in_fragment";
    private Button signInBtn;
    public CallbackManager mCallbackManager;
    private FacebookCallback<LoginResult> mCallback=new FacebookCallback<LoginResult>(){
        @Override
        public void onSuccess(LoginResult loginResult) {
            Intent intent = new Intent(getActivity(),FirstTimeSignInActivity.class);
            startActivity(intent);
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };
    public LogInFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_in_fragment, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager, mCallback);

        // signInBtn = (Button)view.findViewById(R.id.sign_in_btn);
       /* signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFragment();
            }
        });*/

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
  /*  private void toggleFragment() {
        Fragment f = getFragmentManager().findFragmentByTag(SING_IN_FRAGMENT_TAG);
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .replace(R.id.sign_in_fragment, SignInFragment
                                    .instantiate(getActivity(), SignInFragment.class.getName()),
                            SING_IN_FRAGMENT_TAG
                    ).addToBackStack(null).commit();
        }
    }*/
}
