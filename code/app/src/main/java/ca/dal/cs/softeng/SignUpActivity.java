package ca.dal.cs.softeng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import static ca.dal.cs.softeng.database.Accounts.*;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onClick(View view) {
        EditText user = (EditText)findViewById(R.id.sign_up_user);
        EditText password = (EditText)findViewById(R.id.sign_up_password);
        EditText confirm = (EditText)findViewById(R.id.sign_up_password_confirm);

        if(!password.getText().toString().equals(confirm.getText().toString())) {
            ((TextView)findViewById(R.id.error_sign_up)).setText(" Passwords do not match ");
        } else if(addUser(user.getText().toString(), password.getText().toString())) {
            finish();
        } else {
            ((TextView)findViewById(R.id.error_sign_up)).setText(" Username already exists ");
        }
    }
}
