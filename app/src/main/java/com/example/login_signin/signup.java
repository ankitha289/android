package com.example.login_signin;

        import androidx.appcompat.app.AppCompatActivity;

        import androidx.annotation.RequiresApi;

        import android.annotation.SuppressLint;
        import android.os.Build;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import android.os.Bundle;
        import android.content.Intent;
        import android.view.View;
        import android.widget.TextView;

        import com.google.android.material.button.MaterialButton;

//public class signup extends AppCompatActivity {

//  TextView txtSignIn;

//@Override
//protected void onCreate(Bundle savedInstanceState) {
//  super.onCreate(savedInstanceState);
//setContentView(R.layout.activity_signup);

//txtSignIn = findViewById(R.id.txtSignIn);

//txtSignIn.setOnClickListener(new View.OnClickListener() {
//  @Override
// public void onClick(View view) {
//   Intent intent = new Intent(signup.this,login.class);
// startActivity(intent);
//finish();
//}
//});
//}
//}

public class signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Bundle bundle = getIntent().getExtras();
        Button SignUp = findViewById(R.id.register);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText UserName = findViewById(R.id.username);
                EditText PassWord = findViewById(R.id.password);
                String usr = UserName.getText().toString();
                String psw = PassWord.getText().toString();
                if(checkPasswordValidity(psw)){
                    Toast.makeText(signup.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signup.this,login.class);
                    intent.putExtra("UserName",usr);
                    intent.putExtra("Password",psw);
                    startActivity(intent);
                }else{
                    String message = "Password should contain atleast one Uppercase, Lowercase, Letter, Number, Special Character.\n Minimum Length : 8";
                    Toast.makeText(signup.this, ""+message, Toast.LENGTH_LONG).show();
                }
            }
            private boolean checkPasswordValidity(String psw){
                boolean isUpper=false;
                boolean isLower=false;
                boolean isAlphabet=false;
                boolean isNumber=false;
                boolean isSpecial=false;
                int minLength = 8;
                for(int i=0;i<psw.length();i++){
                    char ch = psw.charAt(i);
                    if(Character.isUpperCase(ch)){
                        isUpper = true;
                    }
                    if(Character.isLowerCase(ch)){
                        isLower = true;


                    }
                    {
                        if(Character.isAlphabetic(ch)){
                            isAlphabet = true;
                        }
                    }
                    if(Character.isDigit(ch)){
                        isNumber = true;
                    }
                    if(ch == '@'||ch == '!'||ch == '_'||ch == '#'||ch == '$'){
                        isSpecial = true;
                    }
                    if(isAlphabet && isLower && isUpper && isNumber && isSpecial && psw.length()>=minLength){
                        return true;
                    }
                }
                return false;
            }
        });
    }

}