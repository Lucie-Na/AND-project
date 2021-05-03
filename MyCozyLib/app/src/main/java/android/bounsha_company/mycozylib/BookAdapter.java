package android.bounsha_company.mycozylib;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private final ArrayList<Book> bookArrayList;
    private final Context context;

    // constructor
    public BookAdapter(ArrayList<Book> bookArrayList, Context context)
    {
        this.bookArrayList = bookArrayList;
        this.context = context;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        // below line is use to initialize
        // our text view and image views.
        TextView nameTV, editorTV, pageCountTV, dateTV;
        ImageView bookIV;

        public BookViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.text_book_title);
            editorTV = itemView.findViewById(R.id.text_book_editor);
            pageCountTV = itemView.findViewById(R.id.text_book_page_count);
            dateTV = itemView.findViewById(R.id.text_published_date);
            bookIV = itemView.findViewById(R.id.img_book_cover);
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
        holder.nameTV.setText(book.getTitle());

        holder.editorTV.setText(book.getEditor());
        holder.pageCountTV.setText("No of Pages : " + book.getPageCount());
        holder.dateTV.setText(book.getPublishedDate());

        // below line is use to set image from URL in our image view.
        Picasso.get().load(book.getThumbnail()).into(holder.bookIV);

        // on click listener on holder
        holder.itemView.setOnClickListener(v -> {
            // inside on click listener method we are calling a new activity
            // and passing all the data of that item in next intent.
            Intent i = new Intent(context, Book.class);
            i.putExtra("title", book.getTitle());
            i.putExtra("subtitle", book.getSubtitle());
            i.putExtra("authors", book.getAuthors());
            i.putExtra("publisher", book.getEditor());
            i.putExtra("publishedDate", book.getPublishedDate());
            i.putExtra("description", book.getDescription());
            i.putExtra("pageCount", book.getPageCount());
            i.putExtra("thumbnail", book.getThumbnail());
            i.putExtra("previewLink", book.getPreviewLink());
            i.putExtra("infoLink", book.getInfoLink());

            // after passing that data we are
            // starting our new  intent.
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount()
    {
        return bookArrayList.size();
    }

}
