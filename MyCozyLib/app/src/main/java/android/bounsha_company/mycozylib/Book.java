package android.bounsha_company.mycozylib;

import java.util.ArrayList;

public class Book
{
    private int picture;
    private String title;
    private String subtitle;
    private ArrayList<String> authors;
    private String editor;
    private String publishedDate;
    private int pageCount;

    private String description;

    /*
    private String previewLink;
    private String infoLink;*/

    // constructor
    public Book(String title, String subtitle, ArrayList<String> authors, String editor,
                String publishedDate, String description, int pageCount, int picture,
                String previewLink, String infoLink)
    {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.editor = editor;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pageCount = pageCount;
        this.picture = picture;
       /* this.previewLink = previewLink;
        this.infoLink = infoLink;*/
    }

    // get and set methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String publisher) {
        this.editor = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCoverID() {
        return picture;
    }

    public void setCoverID(int coverID) {
        this.picture = coverID;
    }
/*
    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }
*/
}
