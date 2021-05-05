package android.bounsha_company.mycozylib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private final ArrayList<Book> bookArrayList;
    private final Context context;

    // constructor
    public BookAdapter(ArrayList<Book> bookArrayList, Context context)
    {
        this.bookArrayList = bookArrayList;
        this.context = context;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        TextView bookName;
        TextView bookEditor;
        TextView bookPageCount;
        TextView bookPublishedDate;
        ImageView bookPicture;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.text_book_title);
            bookEditor = itemView.findViewById(R.id.text_book_editor);
            bookPageCount = itemView.findViewById(R.id.text_book_page_count);
            bookPublishedDate = itemView.findViewById(R.id.text_book_published_date);
            bookPicture = itemView.findViewById(R.id.img_book_cover);
        }
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position)
    {
        Book book = bookArrayList.get(position);
        holder.bookName.setText(book.getTitle());

        holder.bookEditor.setText(book.getEditor());
        holder.bookPageCount.setText("No of Pages : " + book.getPageCount());
        holder.bookPublishedDate.setText(book.getPublishedDate());

        // below line is use to set image from URL in our image view.
        Picasso.get().load(book.getCoverPicture()).into(holder.bookPicture);

        // on click listener on holder
        holder.itemView.setOnClickListener(v -> {
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

    @Override
    public int getItemCount()
    {
        return bookArrayList.size();
    }

}
