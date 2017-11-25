package be.movify.dronesteward;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by philippesimons on 25/11/2017.
 */

public class LoginFragment extends Fragment {

    interface LoginListener  {
        void onLoggedIn();
    }

    private LoginListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_fragment, container, false);

        Button mEmailSignInButton = root.findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onLoggedIn();
            }
        });

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mListener = (LoginListener) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mListener = null;
    }
}
