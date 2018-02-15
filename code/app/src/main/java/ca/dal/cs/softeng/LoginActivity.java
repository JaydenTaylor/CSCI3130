package ca.dal.cs.softeng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private HashMap<String,String> accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accounts = new HashMap<String,String>();
        accounts.put("fred123","password");
    }

    public void signIn(View view) {
        String user = ((EditText)findViewById(R.id.email_sign_in)).getText().toString();
        String password = ((EditText)findViewById(R.id.password_sign_in)).getText().toString();

        if(accounts.containsKey(user) && accounts.get(user).matches(password)) {
            validatedLogin();
        } else {
            //do some error
        }
    }

    public void signUp(View view) {
        String user = ((EditText)findViewById(R.id.emial_sign_in)).getText().toString();
        String password = ((EditText)findViewById(R.id.password_sign_in)).getText().toString();

        if(!accounts.containsKey(user)) {
            accounts.put(user,password);
            validatedLogin();
        } else {
            //do some error
        }
    }
    
    /*
        implement in a manner that allows more generic manipulation of the intent and class
        objects being used to start the next activity
    */
    private void validatedLogin() {
        Intent next = new Intent(this,CalendarActivity.class);
        startActivity(calendar);
    }
}
