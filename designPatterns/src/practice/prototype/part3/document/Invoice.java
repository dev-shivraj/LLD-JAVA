package practice.prototype.part3.document;

public class Invoice extends Document {

    public Invoice(String title, String content, String author) {
        super(title, content, author);
    }

    @Override
    public Invoice copy() {
        return new Invoice(this.title, this.content, this.author);
    }
}