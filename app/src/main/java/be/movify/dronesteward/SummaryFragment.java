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

public class SummaryFragment extends Fragment {

    interface SummartyListenr {
        void onConnect();
    }

    private SummartyListenr mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.summary_fragment, container, false);

        Button connect = root.findViewById(R.id.connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onConnect();
            }
        });

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (SummartyListenr) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
