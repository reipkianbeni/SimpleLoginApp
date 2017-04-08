package reipki.com.simpleloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    int attempt_counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton(){
        final EditText username = (EditText)findViewById(R.id.editText_username);
        final EditText password = (EditText)findViewById(R.id.editText_pass);
        final TextView attempt_count = (TextView)findViewById(R.id.textView_AttemptCount);
        final Button login_btn = (Button)findViewById(R.id.button_login);

        attempt_count.setText(Integer.toString(attempt_counter));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                            Toast.makeText(Login.this, "Username and Password Correct", Toast.LENGTH_SHORT).show();
                            Intent user_activity = new Intent("reipki.com.simpleloginapp.user");
                            startActivity(user_activity);
                        } else {
                            Toast.makeText(Login.this, "Username and Password Incorrect", Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            attempt_count.setText(Integer.toString(attempt_counter));
                            if(attempt_counter == 0){
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }
}
