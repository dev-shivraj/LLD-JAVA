package practice.prototype.part3.document;

public class Resume extends Document {

    public Resume(
            String title,
            String content,
            String author
    ) {
        super(
                title,
                content,
                author
        );
    }

    @Override
    public Resume copy() {

        return new Resume(
                this.title,
                this.content,
                this.author
        );
    }
}