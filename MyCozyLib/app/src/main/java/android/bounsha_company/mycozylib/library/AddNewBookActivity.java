package android.bounsha_company.mycozylib.library;

import androidx.appcompat.app.AppCompatActivity;

import android.bounsha_company.mycozylib.R;
import android.bounsha_company.mycozylib.models.Book;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddNewBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);

        // initialize all the fields
        EditText editNewBookTitle = findViewById(R.id.new_book_title);
        EditText editNewBookSubtitle = findViewById(R.id.new_book_subtitle);
        EditText editNewBookAuthor = findViewById(R.id.new_book_authors);
        EditText editNewBookEditor = findViewById(R.id.new_book_editor);
        EditText editNewBookPublishedDate = findViewById(R.id.new_book_published_date);
        EditText editNewBookDescription = findViewById(R.id.new_book_description);
        EditText editNewBookPageCount = findViewById(R.id.new_book_number_of_pages);

        // initialize the button to go back to the library
        ImageButton backButton = findViewById(R.id.btn_add_new_book_back);
        backButton.setOnClickListener( view ->
                {
                    Intent replyIntent = new Intent();
                    setResult(RESULT_CANCELED, replyIntent);
                    finish();
                }
        );

        // initialize the button to add the book
        Button btn = findViewById(R.id.new_book_button_save);
        btn.setOnClickListener(view ->
        {
            Intent replyIntent = new Intent();
            if(editNewBookTitle.getText().toString().isEmpty())
            {
                editNewBookTitle.setError(this.getResources().getString(R.string.error_book_title_empty));
            }
            else
            {
                replyIntent.putExtra("title", editNewBookTitle.getText().toString());
                replyIntent.putExtra("subtitle", getStringField(editNewBookSubtitle));
                replyIntent.putExtra("author", getStringField(editNewBookAuthor));
                replyIntent.putExtra("editor", getStringField(editNewBookEditor));
                replyIntent.putExtra("publishedDate", getIntField(editNewBookPublishedDate));
                replyIntent.putExtra("description", getStringField(editNewBookDescription));
                replyIntent.putExtra("pageCount", getIntField(editNewBookPageCount));
                setResult(RESULT_OK, replyIntent);
                finish();
            }

        });

    }

    private String getStringField(EditText field)
    {
        if(field.getText().toString().isEmpty())
        {
            return "n/a";
        }
        else
        {
            return field.getText().toString();
        }
    }

    private int getIntField(EditText field)
    {
        if(field.getText().toString().isEmpty())
        {
            return 0;
        }
        else
        {
            return  Integer.parseInt(field.getText().toString());
        }

    }

}