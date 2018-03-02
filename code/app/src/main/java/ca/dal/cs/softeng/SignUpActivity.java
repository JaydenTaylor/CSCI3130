package ca.dal.cs.softeng;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static ca.dal.cs.softeng.common.Accounts.*;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";
    private FirebaseAuth dbAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dbAuth = FirebaseAuth.getInstance();
    }

    public void onClick(View view) {
        final EditText user = (EditText)findViewById(R.id.sign_up_user);
        final EditText password = (EditText)findViewById(R.id.sign_up_password);
        final EditText confirm = (EditText)findViewById(R.id.sign_up_password_confirm);

        dbAuth.createUserWithEmailAndPassword(user.getText().toString(), password.getText().toString())
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        FirebaseUser user = dbAuth.getCurrentUser();
                        Log.d(TAG, "signUpWithEmail:success");
                        finish();


                    } else {
                        Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        //finish();
                    }
                }
            });

        /*
        if(!password.getText().toString().equals(confirm.getText().toString())) {
            ((TextView)findViewById(R.id.error_sign_up)).setText(" Passwords do not match ");
        } else if(addUser(user.getText().toString(), password.getText().toString())) {
            finish();
        } else {
            ((TextView)findViewById(R.id.error_sign_up)).setText(" Username already exists ");
        }
        */
    }
}
