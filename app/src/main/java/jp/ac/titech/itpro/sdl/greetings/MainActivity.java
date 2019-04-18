package jp.ac.titech.itpro.sdl.greetings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView outputView;
    private EditText inputName;

    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputView = findViewById(R.id.output_view);
        inputName = findViewById(R.id.input_name);
        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = inputName.getText().toString().trim();
                if (!name.isEmpty()) {
                    outputView.setText(getString(R.string.output_view_format, name));
                }
            }
        });
    }
}
