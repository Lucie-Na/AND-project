/**
 * This class defines the comportment of each element of the recycler view
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.recyclerView;

import android.bounsha_company.mycozylib.BookDetailsFragment;
import android.bounsha_company.mycozylib.R;
import android.bounsha_company.mycozylib.models.Book;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder
{
    private TextView bookTitle;
    private TextView bookSubtitle;
    private TextView bookAuthor;
    private TextView bookEditor;
    private TextView bookPageCount;
    private TextView bookPublishedDate;
    private ImageView bookPicture;

    private View currentView;

    /**
     * BookViewHolder : initialize a BookViewHolder instance
     * @param itemView : current recycler view item
     */
    private BookViewHolder(View itemView)
    {
        super(itemView);
        currentView = itemView;
        bookTitle = itemView.findViewById(R.id.text_book_title);
        bookSubtitle = itemView.findViewById(R.id.text_book_subtitle);
        bookAuthor = itemView.findViewById(R.id.text_book_author);
        bookEditor = itemView.findViewById(R.id.text_book_editor);
        bookPageCount = itemView.findViewById(R.id.text_book_page_count);
        bookPublishedDate = itemView.findViewById(R.id.text_book_published_date);
        bookPicture = itemView.findViewById(R.id.img_book_cover);
    }

    /**
     * bind : bind the view with the corresponding data
     * @param book : book to bind
     */
    public void bind(Book book)
    {
        bookTitle.setText(book.getTitle());
        bookSubtitle.setText(book.getSubtitle());
        bookAuthor.setText(book.getAuthors());
        bookEditor.setText(book.getEditor());
        bookPageCount.setText(currentView.getContext().getResources().getString(R.string.text_book_page_count) + ": " + String.valueOf(book.getPageCount()));
        bookPublishedDate.setText(currentView.getContext().getResources().getString(R.string.text_book_published_date) + ": " +String.valueOf(book.getPublishedDate()));
        //bookPicture.setImageURI(book.getImage());

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
            i.putExtra("thumbnail", book.getImage());
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

    /**
     * create : create a new and inflate it with the corresponding data
     * @param parent : ViewGroup : parent view of the current recycler view item
     * @return : BookViewHolder :
     */
    public static BookViewHolder create (ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_book, parent, false);
        return new BookViewHolder(view);
    }
}
