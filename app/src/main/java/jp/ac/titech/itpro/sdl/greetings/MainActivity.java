package jp.ac.titech.itpro.sdl.greetings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    private final static String KEY_NAME = "MainActivity.name";

    private TextView outputView;
    private EditText inputName;

    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            name = savedInstanceState.getString(KEY_NAME);
        }

        outputView = findViewById(R.id.output_view);
        inputName = findViewById(R.id.input_name);
        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = inputName.getText().toString().trim();
                greet();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        greet();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putString(KEY_NAME, name);
    }

    private void greet() {
        if (name != null && !name.isEmpty()) {
            outputView.setText(getString(R.string.output_view_format, name));
        }
    }
}
