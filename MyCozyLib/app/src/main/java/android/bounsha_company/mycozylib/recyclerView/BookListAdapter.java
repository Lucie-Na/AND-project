package android.bounsha_company.mycozylib.recyclerView;

import android.bounsha_company.mycozylib.recyclerView.BookViewHolder;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import android.bounsha_company.mycozylib.models.Book;


public class BookListAdapter extends ListAdapter<Book, BookViewHolder>
{
    // constructor
    public BookListAdapter(@NonNull DiffUtil.ItemCallback<Book> diffCallback)
    {
        super(diffCallback);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return BookViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position)
    {
        Book currentBook = getItem(position);
        holder.bind(currentBook.getTitle(), currentBook.getSubtitle(), currentBook.getEditor(), currentBook.getPageCount(), currentBook.getPublishedDate(), currentBook.getImage());

        // below line is use to set image from URL in our image view.
        //Picasso.get().load(book.getImage()).into(holder.bookPicture);
    }

    public static class BookDiff extends DiffUtil.ItemCallback<Book>
    {
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem)
        {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem)
        {
            return ( oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getSubtitle().equals(newItem.getSubtitle())
                    && oldItem.getEditor().equals(newItem.getEditor())
                    && oldItem.getPageCount() == (newItem.getPageCount())
                    && oldItem.getPublishedDate() == (newItem.getPublishedDate()) );
        }
    }

}
