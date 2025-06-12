package tp9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    private Stage primaryStage;
    private User currentUser;
    private File selectedImageFile;
    private File profileImageFile;

    private FlowPane postContainer = new FlowPane(10, 10);
    private ArrayList<Post> posts = new ArrayList<>();
    private Scene homeScene;
    private VBox homeLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showRegisterScene();
    }

    private void showRegisterScene() {
        Label title = new Label("Input User Account");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label nickLabel = new Label("Nick Name");
        TextField nickField = new TextField();
        nickField.setPrefWidth(300);

        Label fullLabel = new Label("Full Name");
        TextField fullField = new TextField();
        fullField.setPrefWidth(300);

        Circle profileCircle = new Circle(50, Color.BLACK);
        ImageView profilePreview = new ImageView();
        profilePreview.setFitWidth(100);
        profilePreview.setFitHeight(100);
        profilePreview.setPreserveRatio(false);
        profilePreview.setVisible(false);

        Circle previewClip = new Circle(50, 50, 50);
        profilePreview.setClip(previewClip);

        Button uploadBtn = new Button("Upload Foto Profil");
        uploadBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            profileImageFile = fileChooser.showOpenDialog(primaryStage);

            if (profileImageFile != null) {
                profilePreview.setImage(new Image(profileImageFile.toURI().toString()));
                profilePreview.setVisible(true);
                profileCircle.setVisible(false);
            }
        });

        Button registerBtn = new Button("Submit");
        registerBtn.setOnAction(e -> {
            String nick = nickField.getText();
            String full = fullField.getText();
            if (!nick.isEmpty() && !full.isEmpty() && profileImageFile != null) {
                currentUser = new User(nick, full, new Image(profileImageFile.toURI().toString()));
                showHomeScene();
            } else {
                showAlert("Please fill all fields and upload a profile image.");
            }
        });

        StackPane imageContainer = new StackPane();
        imageContainer.getChildren().addAll(profileCircle, profilePreview);

        VBox layout = new VBox(15);
        layout.getChildren().addAll(title, nickLabel, nickField, fullLabel, fullField, uploadBtn, imageContainer,
                registerBtn);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MyMoment");
        primaryStage.show();
    }

    private void showHomeScene() {
        Label title = new Label("Welcome to MediaShare!");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ImageView profileView = new ImageView(currentUser.profileImage);
        profileView.setFitWidth(100);
        profileView.setFitHeight(100);
        profileView.setPreserveRatio(false);

        Circle clip = new Circle(50, 50, 50);
        profileView.setClip(clip);

        Label nickLabel = new Label("Nickname: " + currentUser.nickName);
        Label fullLabel = new Label("Full Name: " + currentUser.fullName);

        Button addPostBtn = new Button("Add Post");
        addPostBtn.setOnAction(e -> showUploadPostScene());

        HBox profileBox = new HBox(20, profileView, new VBox(5, nickLabel, fullLabel, addPostBtn));
        profileBox.setAlignment(Pos.CENTER_LEFT);
        profileBox.setPadding(new Insets(10));

        postContainer.getChildren().clear();
        postContainer.setAlignment(Pos.TOP_CENTER);
        postContainer.setPadding(new Insets(10));
        postContainer.setHgap(8);
        postContainer.setVgap(15);

        homeLayout = new VBox(10, title, profileBox);
        homeLayout.setPadding(new Insets(10));

        ScrollPane scrollPane = new ScrollPane(postContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(10));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        homeLayout.getChildren().add(scrollPane);

        homeScene = new Scene(homeLayout, 800, 600);
        primaryStage.setScene(homeScene);
        primaryStage.setTitle("MediaShare - Home");

        primaryStage.show();
        updatePosts();

        homeScene.widthProperty().addListener((obs, oldVal, newVal) -> updatePosts());
        homeScene.heightProperty().addListener((obs, oldVal, newVal) -> updatePosts());
    }

    private void updatePosts() {
        if (homeScene == null || postContainer == null)
            return;

        postContainer.getChildren().clear();

        double availableWidth = homeScene.getWidth() - 60; // margin kiri kanan + scrollbar

        double spacing = 8; // jarak antar post
        double targetPostsPerRow = 3;
        double postWidth = (availableWidth - (spacing * (targetPostsPerRow - 1))) / targetPostsPerRow;

        postWidth = Math.max(180, Math.min(250, postWidth));

        for (Post post : posts) {
            VBox imageBox = createPostBox(post, postWidth);
            postContainer.getChildren().add(imageBox);
        }

        postContainer.setPrefWrapLength(availableWidth);
    }

    private VBox createPostBox(Post post, double boxWidth) {

        double imageSize = boxWidth - 20;

        ImageView imageView = new ImageView(post.image);
        imageView.setFitWidth(imageSize);
        imageView.setFitHeight(imageSize);
        imageView.setPreserveRatio(true);

        // Membuat efek timbul saat hover
        DropShadow hoverEffect = new DropShadow();
        hoverEffect.setColor(Color.GRAY);
        hoverEffect.setOffsetX(3);
        hoverEffect.setOffsetY(3);
        hoverEffect.setRadius(10);

        // Event handler untuk hover effect
        imageView.setOnMouseEntered(e -> {
            imageView.setEffect(hoverEffect);
            imageView.setScaleX(1.05);
            imageView.setScaleY(1.05);
        });

        imageView.setOnMouseExited(e -> {
            imageView.setEffect(null);
            imageView.setScaleX(1.0);
            imageView.setScaleY(1.0);
        });

        VBox captionBox = createExpandableCaption(post.caption, boxWidth - 20);
        captionBox.setVisible(false);
        captionBox.setManaged(false);

        VBox imageBox = new VBox(5, imageView, captionBox);
        imageBox.setAlignment(Pos.CENTER);
        imageBox.setPadding(new Insets(10));
        imageBox.setStyle(
                "-fx-border-color: #ddd; -fx-border-radius: 8; -fx-background-color: #ffffff; -fx-background-radius: 8;");
        imageBox.setPrefWidth(boxWidth);
        imageBox.setMaxWidth(boxWidth);
        imageBox.setMinWidth(boxWidth);

        // Event handler untuk klik gambar - toggle caption visibility
        imageView.setOnMouseClicked(e -> {
            if (captionBox.isVisible()) {

                showPostDetailScene(post);
            } else {

                captionBox.setVisible(true);
                captionBox.setManaged(true);
            }
        });

        return imageBox;
    }

    private VBox createExpandableCaption(String fullCaption, double maxWidth) {
        VBox captionContainer = new VBox(2);
        captionContainer.setMaxWidth(maxWidth);

        String truncatedCaption = truncateCaption(fullCaption, 20);
        boolean isTruncated = truncatedCaption.length() < fullCaption.length();

        Text captionText = new Text(truncatedCaption);
        captionText.setWrappingWidth(maxWidth - 10);
        captionText.setStyle("-fx-font-size: 12px;");

        captionContainer.getChildren().add(captionText);

        if (isTruncated) {

            Label moreLabel = new Label("...Lihat Selengkapnya");
            moreLabel.setStyle("-fx-text-fill: #1976D2; -fx-font-size: 11px; -fx-cursor: hand; -fx-underline: true;");
            moreLabel.setOnMouseClicked(e -> {

                captionText.setText(fullCaption);
                captionContainer.getChildren().remove(moreLabel);

                Label lessLabel = new Label("Lebih Sedikit");
                lessLabel.setStyle(
                        "-fx-text-fill: #1976D2; -fx-font-size: 11px; -fx-cursor: hand; -fx-underline: true;");
                lessLabel.setOnMouseClicked(e2 -> {

                    captionText.setText(truncatedCaption);
                    captionContainer.getChildren().remove(lessLabel);
                    captionContainer.getChildren().add(moreLabel);
                });
                captionContainer.getChildren().add(lessLabel);
            });
            captionContainer.getChildren().add(moreLabel);
        }

        return captionContainer;
    }

    private String truncateCaption(String caption, int maxChars) {
        if (caption.length() <= maxChars) {
            return caption;
        }

        String truncated = caption.substring(0, maxChars);
        int lastSpace = truncated.lastIndexOf(' ');

        if (lastSpace > 0 && lastSpace > maxChars * 0.7) {

            truncated = truncated.substring(0, lastSpace);
        }

        return truncated;
    }

    private void showUploadPostScene() {
        Label title = new Label("Upload post");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button imageBtn = new Button("Upload Image");

        ImageView imagePreview = new ImageView();
        imagePreview.setFitWidth(200);
        imagePreview.setFitHeight(150);
        imagePreview.setPreserveRatio(true);
        imagePreview.setStyle("-fx-border-color: #ccc;");
        imagePreview.setVisible(false);

        imageBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter(
                    "Image Files", "*.png", "*.jpg", "*.jpeg");
            fileChooser.getExtensionFilters().add(imageFilter);
            selectedImageFile = fileChooser.showOpenDialog(primaryStage);

            if (selectedImageFile != null) {
                imagePreview.setImage(new Image(selectedImageFile.toURI().toString()));
                imagePreview.setVisible(true);
            }
        });

        Label captionLabel = new Label("Caption");
        TextField captionField = new TextField();
        captionField.setPrefWidth(300);

        Button submitBtn = new Button("Submit");
        submitBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        submitBtn.setOnAction(e -> {
            String caption = captionField.getText();

            // Validasi input
            if (selectedImageFile == null) {
                showAlert("Please select an image first!");
                return;
            }

            if (caption.isEmpty()) {
                showAlert("Please enter a caption!");
                return;
            }

            Image image = new Image(selectedImageFile.toURI().toString());
            posts.add(new Post(image, caption));
            selectedImageFile = null; // Reset selection
            showHomeScene();
        });

        Button backBtn = new Button("Back");
        backBtn.setOnAction(e -> showHomeScene());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(title, imageBtn, imagePreview, captionLabel, captionField, submitBtn, backBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Upload post");
    }

    private void showPostDetailScene(Post post) {
        Label captionLabel = new Label(post.caption);
        captionLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        captionLabel.setWrapText(true);

        ImageView imageView = new ImageView(post.image);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showHomeScene());

        VBox layout = new VBox(20, imageView, captionLabel, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.showAndWait();
    }

    class User {
        String nickName;
        String fullName;
        Image profileImage;

        User(String nickName, String fullName, Image profileImage) {
            this.nickName = nickName;
            this.fullName = fullName;
            this.profileImage = profileImage;
        }
    }

    class Post {
        Image image;
        String caption;

        Post(Image image, String caption) {
            this.image = image;
            this.caption = caption;
        }
    }
}