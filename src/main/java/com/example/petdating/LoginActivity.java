package com.example.petdating;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import com.google.android.gms.common.SignInButton;

@SuppressWarnings("deprecation")
public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 100;
    GoogleSignInClient mGoogleSignInClient;
    EditText mail, password;
    Button btn_login;
    TextView reset_Password;
    TextView signup;
    SignInButton gooleSingin;
    ProgressDialog progressDialog;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        gooleSingin = findViewById(R.id.google_button);
        setGooglePlusButtonText(gooleSingin, getString(R.string.google_login));

        LoginButton fb_login = findViewById(R.id.fblogin_button);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Logging in Please Wait....");


        mail = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.loginButton);
        reset_Password = findViewById(R.id.forgot_password);
        signup = findViewById(R.id.signUp);

        signup.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            finish();
        });

        reset_Password.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, ForgotPassword.class)));

        btn_login.setOnClickListener(view -> LoginMethod());

        fb_login.setOnClickListener(view -> {
            progressDialog.show();
            new Handler().postDelayed(() -> {
                progressDialog.dismiss();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }, 3000);
        });

        gooleSingin.setOnClickListener(view -> {
            progressDialog.show();
            new Handler().postDelayed(() -> {
                progressDialog.dismiss();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }, 3000);
        });
    }

    private void LoginMethod() {
        progressDialog.show();
        String txt_emial = mail.getText().toString();
        String txt_password = password.getText().toString();

        if (TextUtils.isEmpty(txt_emial) | TextUtils.isEmpty(txt_password)) {
            Toast.makeText(LoginActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }

    protected void setGooglePlusButtonText(SignInButton signInButton, String buttonText) {
        // Find the TextView that is inside of the SignInButton and set its text
        for (int i = 0; i < signInButton.getChildCount(); i++) {
            View v = signInButton.getChildAt(i);

            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setText(buttonText);
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
