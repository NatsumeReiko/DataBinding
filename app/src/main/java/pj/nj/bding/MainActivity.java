package pj.nj.bding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.normal).setOnClickListener(this);
        findViewById(R.id.data_binding).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normal:
                startActivity(new Intent(this, NormalActivity.class));
                break;
            case R.id.data_binding:
                startActivity(new Intent(this, DataBindingActivity.class));
                break;
        }

    }
}
