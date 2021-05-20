/**
 * This class associates data with the view holder
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.recyclerView;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import android.bounsha_company.mycozylib.models.Book;

import java.util.List;


public class BookListAdapter extends ListAdapter<Book, BookViewHolder>
{
    /**
     * BookAdapter : initialize a new instance of the class BookAdapter
     * @param diffCallback : @NonNull DiffUtil.ItemCallback<Book> :
     */
    public BookListAdapter(@NonNull DiffUtil.ItemCallback<Book> diffCallback)
    {
        super(diffCallback);
    }

    /**
     * onCreateViewHolder : create a new instance of BookViewHolder
     * @param parent : ViewGroup : the group where the new view will be added
     * @param viewType : int : type of the new view
     * @return BookViewHolder : new item's view
     */
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return BookViewHolder.create(parent);
    }

    /**
     * onBindViewHolder : recycle a view
     * @param holder : BookViewHolder : the view holder that will contain the new data
     * @param position : int : item position in the recycler view
     */
    @Override
    public void onBindViewHolder(BookViewHolder holder, int position)
    {
        Log.e("Debug", "Adapter : begin to bind the data");
        holder.bind(getItem(position));
    }

    /**
     * This local class compares 2 instances of the class Book
     */
    public static class BookDiff extends DiffUtil.ItemCallback<Book>
    {
        /**
         * areItemsTheSame : compare 2 Book instances
         * @param oldItem : @NonNull Book : old Book instance
         * @param newItem : @NonNull Book : new Book instance
         * @return true if the 2 instances are the same, false otherwise
         */
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem)
        {
            Log.e("Debug", "Adapter.BookDiff : verify if items are the same");
            return oldItem == newItem;
        }

        /**
         * areContentsTheSame : compare the content of 2 Book instances
         * @param oldItem : @NonNull Book : old Book instance
         * @param newItem : @NonNull Book : new Book instance
         * @return true is the 2 instances content are the same, false otherwise
         */
        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem)
        {
            Log.e("Debug", "Adapter.BookDiff : verify if contents are the same");
            return ( oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getSubtitle().equals(newItem.getSubtitle())
                    && oldItem.getAuthors().equals(newItem.getAuthors())
                    && oldItem.getEditor().equals(newItem.getEditor())
                    && oldItem.getPublishedDate() == (newItem.getPublishedDate())
                    && oldItem.getPageCount() == (newItem.getPageCount())
                    && oldItem.getDescription().equals(newItem.getDescription())
                    && oldItem.getImage().equals(newItem.getImage()) );
        }
    }

}
