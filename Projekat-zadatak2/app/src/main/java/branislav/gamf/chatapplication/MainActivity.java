package branislav.gamf.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.text.Editable;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText usernameTextEdit = (EditText) findViewById(R.id.loginUsername);
        final EditText passwordTextEdit = (EditText) findViewById(R.id.loginPassword);
        final Button loginButton = (Button) findViewById(R.id.buttonLogin);
        final Button registerButton = (Button) findViewById(R.id.buttonRegister);
        final boolean[] usernameValid = {false};
        final boolean[] passwordValid = {false};


        usernameTextEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String username = usernameTextEdit.getText().toString();
                if(username.length() != 0){
                    usernameValid[0] = true;
                    if(passwordValid[0])
                        loginButton.setEnabled(true);
                }
                else{
                    usernameValid[0] = false;
                    loginButton.setEnabled(false);
                }
            }
        });

        passwordTextEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String password = passwordTextEdit.getText().toString();
                if(password.length() >= 6){
                    passwordValid[0] = true;
                    if(usernameValid[0])
                        loginButton.setEnabled(true);
                }
                else{
                    passwordValid[0] = false;
                    loginButton.setEnabled(false);
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ContactsActivity.class));
            }
        });

    }




}
