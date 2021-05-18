package android.bounsha_company.mycozylib.library;

import androidx.appcompat.app.AppCompatActivity;

import android.bounsha_company.mycozylib.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddNewBookActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.booksql.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);

        EditText editNewBookTitle = findViewById(R.id.new_book_title);
        EditText editNewBookSubtitle = findViewById(R.id.new_book_subtitle);
        EditText editNewBookAuthor = findViewById(R.id.new_book_authors);
        EditText editNewBookEditor = findViewById(R.id.new_book_editor);
        EditText editNewBookPublishedDate = findViewById(R.id.new_book_published_date);
        EditText editNewBookDescription = findViewById(R.id.new_book_description);
        EditText editNewBookPageCount = findViewById(R.id.new_book_number_of_pages);

        ImageButton backButton = findViewById(R.id.btn_add_new_book_back);
        //backButton.setOnClickListener();

        Button btn = findViewById(R.id.new_book_button_save);
        btn.setOnClickListener(view ->
        {
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(editNewBookTitle.getText()))
            {
                setResult(RESULT_CANCELED, replyIntent);
            }
            else
            {
                replyIntent.putExtra(EXTRA_REPLY, editNewBookTitle.getText().toString());
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

}