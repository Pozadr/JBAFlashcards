class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return this.authors.clone();
    }

    public void setAuthors(String[] authors) {
        this.authors = authors.clone();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}