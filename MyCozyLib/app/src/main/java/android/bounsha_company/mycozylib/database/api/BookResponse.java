package android.bounsha_company.mycozylib.database.api;

import android.bounsha_company.mycozylib.models.Book;

public class BookResponse
{
    private String title;
    private String subtitle;
    private String authors;
    private String publisher;
    private int publishedDate;
    private String description;
    private int pageCount;
    private String thumbnail;

    public Book getBook()
    {
        return new Book(title, subtitle, authors, publisher, publishedDate, description, pageCount, thumbnail);
    }
}
