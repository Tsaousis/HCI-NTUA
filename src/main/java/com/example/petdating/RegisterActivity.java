package com.example.petdating;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    EditText etfirstname, etlastname, etmail, etpassword, etlocation;
    Button register_Button;
    EditText dd, mm, yyyy;
    String DD, MM, YYYY;
    TextView login;

    ProgressDialog progressDialog;

    long a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setMessage("Signing Up Please Wait...");
        etfirstname = findViewById(R.id.firstname);
        etlastname = findViewById(R.id.lastname);
        etmail = findViewById(R.id.email);
        etpassword = findViewById(R.id.password);
        etlocation = findViewById(R.id.location);
        dd = findViewById(R.id.etday);
        mm = findViewById(R.id.etmonth);
        yyyy = findViewById(R.id.etyear);
        login = findViewById(R.id.signIn);
        login.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        DD = dd.getText().toString();
        MM = mm.getText().toString();
        YYYY = yyyy.getText().toString();


        register_Button = (Button) findViewById(R.id.registerButton);
        register_Button.setOnClickListener(view -> {
            String nam = etfirstname.getText().toString();
            String loc = etlocation.getText().toString();
            String lastname = etlastname.getText().toString();
            String pass = etpassword.getText().toString();
            String email = etmail.getText().toString();
            if (TextUtils.isEmpty(nam)) {
                etfirstname.setError("First Name cannot be blank");
            } else if (TextUtils.isEmpty(lastname)) {
                etlastname.setError("Last Name cannot be blank");
            } else if (TextUtils.isEmpty(pass)) {
                etpassword.setError("Password is required");
            } else if (TextUtils.isEmpty(email)) {
                etmail.setError("Email is Required");
            } else if (pass.length() < 6) {
                etpassword.setError("Passowrd must be greater than 6 digits");
            } else if (TextUtils.isEmpty(loc)) {//No Radio Button Is Checked
                etlocation.setError("Location cannot be empty");
            } else {
                Register(nam, email, pass);
            }
        });
    }

    public void Register(final String name, final String email, final String password) {
        progressDialog.show();
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }


}
