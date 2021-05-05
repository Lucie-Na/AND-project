package android.bounsha_company.mycozylib;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter_v2 extends RecyclerView.Adapter<BookAdapter_v2.BookViewHolder>
{
    private ArrayList<Book> arrayListBook;

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position)
    {
        holder.bookTitle.setText(arrayListBook.get(position).getTitle());
        holder.bookSubtitle.setText(arrayListBook.get(position).getSubtitle());
        holder.bookEditor.setText(arrayListBook.get(position).getEditor());
        holder.bookNumberOfPages.setText(arrayListBook.get(position).getPageCount());
        holder.bookPublishedDate.setText(arrayListBook.get(position).getPublishedDate());
        holder.bookCover.setImageResource(arrayListBook.get(position).getCoverID());
    }

    @Override
    public int getItemCount()
    {
        return arrayListBook.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder
    {
        TextView bookTitle;
        TextView bookSubtitle;
        TextView bookEditor;
        TextView bookNumberOfPages;
        TextView bookPublishedDate;
        ImageView bookCover;

        public BookViewHolder(@NonNull View itemView)
        {
            super(itemView);

            bookTitle = itemView.findViewById(R.id.text_book_title);
            bookSubtitle = itemView.findViewById(R.id.text_book_subtitle);
            bookEditor = itemView.findViewById(R.id.text_book_editor);
            bookNumberOfPages = itemView.findViewById(R.id.text_book_page_count);
            bookPublishedDate = itemView.findViewById(R.id.text_book_published_date);
            bookCover = itemView.findViewById(R.id.img_book_cover);

        }

    }

    BookAdapter_v2(ArrayList<Book> bookArrayList)
    {
        this.arrayListBook = bookArrayList;
    }


}
