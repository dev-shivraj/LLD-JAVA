package practice.prototype.part3.document;

public abstract class Document implements Prototype<Document> {

    protected String title;
    protected String content;
    protected String author;

    protected Document(
            String title,
            String content,
            String author
    ) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}