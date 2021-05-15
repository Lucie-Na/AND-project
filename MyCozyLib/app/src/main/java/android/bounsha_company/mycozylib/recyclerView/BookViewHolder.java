package android.bounsha_company.mycozylib.recyclerView;

import android.bounsha_company.mycozylib.BookDetailsFragment;
import android.bounsha_company.mycozylib.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder
{
    private TextView bookTitle;
    private TextView bookSubtitle;
    private TextView bookEditor;
    private TextView bookPageCount;
    private TextView bookPublishedDate;
    private ImageView bookPicture;

    private BookViewHolder(@NonNull View itemView)
    {
        super(itemView);
        bookTitle = itemView.findViewById(R.id.text_book_title);
        bookSubtitle = itemView.findViewById(R.id.text_book_subtitle);
        bookEditor = itemView.findViewById(R.id.text_book_editor);
        bookPageCount = itemView.findViewById(R.id.text_book_page_count);
        bookPublishedDate = itemView.findViewById(R.id.text_book_published_date);
        bookPicture = itemView.findViewById(R.id.img_book_cover);
    }

    public void bind(String title, String subtitle, String editor, int pageCount, int publishedDate, String cover )
    {
        bookTitle.setText(title);
        bookSubtitle.setText(subtitle);
        bookEditor.setText(editor);
        bookPageCount.setText(pageCount);
        bookPublishedDate.setText(publishedDate);
        //bookPicture.setImageURI(cover);

        itemView.setOnClickListener(v -> {
            // inside on click listener method we are calling a new activity
            // and passing all the data of that item in next intent.
            /*Intent i = new Intent(context, Book.class);
            i.putExtra("title", book.getTitle());
            i.putExtra("subtitle", book.getSubtitle());
            i.putExtra("authors", book.getAuthors());
            i.putExtra("publisher", book.getEditor());
            i.putExtra("publishedDate", book.getPublishedDate());
            i.putExtra("description", book.getDescription());
            i.putExtra("pageCount", book.getPageCount());
            i.putExtra("thumbnail", book.getCoverPicture());
            i.putExtra("previewLink", book.getPreviewLink());
            i.putExtra("infoLink", book.getInfoLink());

            // after passing that data we are
            // starting our new  intent.
            context.startActivity(i);*/
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Fragment fragment = new BookDetailsFragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main_container, fragment).commit();
        });
    }

    static BookViewHolder create (ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_book, parent, false);
        return new BookViewHolder(view);
    }
}
