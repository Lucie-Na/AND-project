package android.bounsha_company.mycozylib;

import java.util.ArrayList;

public class Book
{
    private String title;
    private String subtitle;
    private ArrayList<String> authors;
    private String editor;
    private String publishedDate;
    private String description;
    private int pageCount;
    private String thumbnail;
    private String previewLink;
    private String infoLink;

    // constructor
    public Book(String title, String subtitle, ArrayList<String> authors, String editor,
                String publishedDate, String description, int pageCount, String thumbnail,
                String previewLink, String infoLink)
    {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.editor = editor;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pageCount = pageCount;
        this.thumbnail = thumbnail;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

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

}
