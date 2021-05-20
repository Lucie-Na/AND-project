package android.bounsha_company.mycozylib.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.bounsha_company.mycozylib.MainActivity;
import android.bounsha_company.mycozylib.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.auth.data.model.User;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity
{


    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       /* viewModel = new ViewModelProvider(this).get(LogInViewModel.class);
        viewModel.init();
        checkIfSignedIn();*/
        setContentView(R.layout.activity_log_in);

        // set up the database
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        // initialize the fields
        textInputEmail = findViewById(R.id.text_input_log_in_mail);
        textInputPassword = findViewById(R.id.text_input_log_in_password);

        // initialize the sign in text
        TextView signInLink = findViewById(R.id.link_sign_in);
        signInLink.setMovementMethod(LinkMovementMethod.getInstance());
        Spannable spans = (Spannable) signInLink.getText();
        ClickableSpan clickSpan = new ClickableSpan()
        {
            @Override
            public void onClick(View widget)
            {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        };
        spans.setSpan(clickSpan, 0, spans.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public void submitLogIn(View v)
    {
        logIn();
    }

    private void logIn()
    {
        /*users.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String mail = textInputEmail.getEditText().getText().toString().trim();
                String password = textInputPassword.getEditText().getText().toString().trim();
                if(!mail.isEmpty() && snapshot.child(mail).exists())
                {
                    User login = snapshot.child(mail).getValue(User.class);
                    /*if(login.().equals(password))
                    {*/
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    /*}
                    else
                    {
                        textInputPassword.setError(getString(R.string.error_log_in_password_do_not_match));
                    }*/
               /* }
                else

                {
                    textInputEmail.setError(getString(R.string.error_log_in_mail_do_not_exist));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });*/
    }

    /*

    private void checkIfSignedIn()
    {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null)
            {
                String message = "Welcome " + user.getDisplayName();
                welcomeMessage.setText(message);
            } else
                startLoginActivity();
        });
    }

    private void startLoginActivity()
    {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    public void signOut(View v)
    {
        viewModel.signOut();
    }*/
}