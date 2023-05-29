package com.example.login_signin;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
public class login extends AppCompatActivity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button SignIn = findViewById(R.id.signin);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                final String signedUsername = bundle.getString("UserName");
                final String signedPassword = bundle.getString("Password");
                EditText UserName = findViewById(R.id.Username);
                EditText PassWord = findViewById(R.id.Password);
                String usr = UserName.getText().toString().trim();
                String psw = PassWord.getText().toString().trim();
                if (usr.equals(signedUsername) && psw.equals(signedPassword)) {

                    Toast.makeText(login.this, "Successful Login!!", Toast.LENGTH_LONG).show();

                } else {
                    counter++;
                    if (counter == 1) {
                        Toast.makeText(login.this, "Invalid Credentials, 2 Attempts Left", Toast.LENGTH_SHORT).show();
                    } else if (counter == 2) {
                        Toast.makeText(login.this, "Invalid Credentials, 1 Attempts Left", Toast.LENGTH_SHORT).show();
                    } else if (counter == 3) {
                        Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        SignIn.setEnabled(false);
                    }

                }
            }
        });
    }
}

