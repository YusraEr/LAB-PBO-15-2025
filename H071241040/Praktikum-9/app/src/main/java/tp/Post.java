package tp;
import javafx.scene.image.Image;

public class Post {
    private Image postImage;
    private String caption;

    public Post(Image postImage, String caption) {
        this.postImage = postImage;
        this.caption = caption;
    }

    public Image getPostImage() { return postImage; }
    public String getCaption() { return caption; }
}
