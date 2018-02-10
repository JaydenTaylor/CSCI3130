package ca.dal.cs.softeng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signIn(View view) {
        Intent calendar = new Intent(this,CalendarActivity.class);
        startActivity(calendar);
    }
}
