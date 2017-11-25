package be.movify.dronesteward;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.cameraview.CameraView;

/**
 * Created by philippesimons on 25/11/2017.
 */

public class ScannerFragment extends Fragment {

    private CameraView mCameraView;

    interface ScannerListner {
        void onScanned();
    }

    private ScannerListner mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.scanner_fragment, container, false);
        mCameraView = root.findViewById(R.id.camera);
        mCameraView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onScanned();
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCameraView.start();
    }

    @Override
    public void onPause() {
        mCameraView.stop();
        super.onPause();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (ScannerListner) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
