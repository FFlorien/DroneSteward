package be.movify.dronesteward;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements LoginFragment.LoginListener, ScannerFragment.ScannerListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new LoginFragment()).commit();
        }
    }

    @Override
    public void onLoggedIn() {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new ScannerFragment()).commit();
    }

    @Override
    public void onScanned() {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new SummaryFragment()).commit();
    }
}
