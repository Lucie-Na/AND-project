/**
 * This activity sign in a new user
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.bounsha_company.mycozylib.R;
import android.bounsha_company.mycozylib.models.User;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {
    /*
     * The password need to have at least :
     * - 8 characters
     * - 1 uppercase letter
     * - 1 digit
     */
    private static final Pattern PATTERN_PASSWORD =
            Pattern.compile("^(?=.*?[A-Z])(?=.*?[0-9]).{8,}$");

    private TextInputLayout textInputPseudo;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private ProgressBar progressBar;
    private Button submitButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        // initialize fields
        textInputPseudo = findViewById(R.id.text_input_sign_in_pseudo);
        textInputEmail = findViewById(R.id.text_input_sign_in_mail);
        textInputPassword = findViewById(R.id.text_input_sign_in_password);
        textInputConfirmPassword = findViewById(R.id.text_input_sign_in_confirm_password);

        // initialize progress bar
        ProgressBar progressBar = findViewById(R.id.progress_bar_sign_in);

        // initialize submit button
        Button submitButton = findViewById(R.id.button_sign_in_submit);
        submitButton.setOnClickListener(v -> {
            sign_in();
        });
    }


    /**
     * validateDefault : check if the field is not empty
     * @param textToValidate : TextInputLayout : layout input to validate
     * @return boolean : true if the field is filled, otherwise false
     */
    private boolean validateDefault(TextInputLayout textToValidate) {
        String textInput = textToValidate.getEditText().getText().toString().trim();

        // remove the previous error message
        textToValidate.setError(null);

        // verify if the field is not empty
        if (textInput.isEmpty())
        {
            textToValidate.setError(getString(R.string.error_sign_in));
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * validateEmail : check if the email input match an email pattern
     * @return boolean : true if the email input match an email pattern, otherwise false
     */
    private boolean validateEmail()
    {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();
        // apply the default verification
        boolean defaultVerificationPassed = validateDefault(textInputEmail);

        // verify if the input matches with an email pattern
        if (defaultVerificationPassed && !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError(getString(R.string.error_sign_in_mail_wrong_format));
            return false;
        }
        else
            {
            return true;
        }
    }


    /**
     * validatePassword : verified the password and the confirmed password
     * @return boolean : true if the password is valid, false otherwise
     */
    private boolean validatePassword()
    {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();
        String confirmPasswordInput = textInputConfirmPassword.getEditText().getText().toString().trim();

        // apply the default verification
        boolean defaultVerificationPassed = validateDefault(textInputPassword);
        defaultVerificationPassed &= validateDefault(textInputConfirmPassword);

        // verify if the input matches with required security
        if (defaultVerificationPassed && !PATTERN_PASSWORD.matcher(passwordInput).matches()) {
            textInputPassword.setError(getString(R.string.error_sign_in_password_too_weak));
            return false;
        }
        // verify that the passwords match
        else if (defaultVerificationPassed && passwordInput.compareTo(confirmPasswordInput) != 0)
        {
            textInputConfirmPassword.setError(getString(R.string.error_sign_in_confirm_password_do_not_match));
            return false;
        } else
        {
            return true;
        }
    }

    private boolean validateAllFields()
    {
        return (validateDefault(textInputPseudo) &
                validateEmail() &
                validatePassword());
    }

    /**
     * sign_in : sign in a new user
     */
    public void sign_in() {
        if (!validateAllFields()) {
            Toast.makeText(this, getString(R.string.error_sign_in), Toast.LENGTH_SHORT).show();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            //create a new user
            mAuth.createUserWithEmailAndPassword(textInputEmail.getEditText().getText().toString().trim(), textInputPassword.getEditText().getText().toString().trim())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            //if the sign in is a success
                            if (task.isSuccessful())
                            {
                                User user = new User(textInputPseudo.getEditText().getText().toString().trim(), textInputEmail.getEditText().getText().toString().trim());
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>()
                                {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SignInActivity.this, R.string.sign_in_success, Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.GONE);
                                            // redirect to log in page
                                            goToLogInActivity();
                                        }
                                        else {
                                            Toast.makeText(SignInActivity.this, "Failed to register.", Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(SignInActivity.this, "Failed to register.", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        }
    }

    /**
     * goToLogInActivity : return to the log in page
     */
    private void goToLogInActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }


}