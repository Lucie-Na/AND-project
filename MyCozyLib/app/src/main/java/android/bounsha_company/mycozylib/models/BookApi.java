package android.bounsha_company.mycozylib.models;

import androidx.annotation.NonNull;

public class BookApi extends Book
{

    public BookApi(@NonNull String title, String subtitle, String author, String publisher, int publish_date, String description, int number_of_pages, String url)
    {
        super(title, subtitle, author, publisher, publish_date, description, number_of_pages, url);
    }
}
