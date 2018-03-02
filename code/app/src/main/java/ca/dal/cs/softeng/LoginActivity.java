package ca.dal.cs.softeng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import static ca.dal.cs.softeng.common.Accounts.*;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth dbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbAuth.getInstance();
    }
    
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser account = dbAuth.getCurrentUser();
        if(account != null) {
            Intent calendar = new Intent(this, MainActivity.class);
            startActivity(calendar);
        }
    }

    public void signIn(View view) {
        String user = ((EditText)findViewById(R.id.email_sign_in)).getText().toString();
        String password = ((EditText)findViewById(R.id.password_sign_in)).getText().toString();

        dbAuth.signInWithEmailAndPassword(user, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        if(user != null) {
                            Intent calendar = new Intent(this, MainActivity.class);
                            startActivity(calendar);
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }

                // ...
                }
            });
    }

    public void signUp(View view) {
        Intent signUp = new Intent(this,SignUpActivity.class);
        startActivity(signUp);
    }
}
