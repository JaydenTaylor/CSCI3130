package ca.dal.cs.softeng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import java.util.HashMap;
import static ca.dal.cs.softeng.database.Accounts.*;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void signIn(View view) {
        String user = ((EditText)findViewById(R.id.email_sign_in)).getText().toString();
        String password = ((EditText)findViewById(R.id.password_sign_in)).getText().toString();

        if(checkPassword(user, password)) {
            Intent calendar = new Intent(this, CalendarActivity.class);
            startActivity(calendar);
        } else {
            ((TextView)findViewById(R.id.error_sign_in)).setText(" Invalid username or password ");
        }
    }

    public void signUp(View view) {
        Intent signUp = new Intent(this,SignUpActivity.class);
        startActivity(signUp);
    }
}
