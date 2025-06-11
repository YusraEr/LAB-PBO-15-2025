package tp;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

public class App extends Application {
    private User currentUser;
    private int postCount = 0;
    private GridPane postContainer;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        showRegisterScene(primaryStage);
    }

    private void showRegisterScene(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        TextField nicknameField = new TextField();
        nicknameField.setPromptText("Nickname");

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");

        Button uploadButton = new Button("Upload Profile Image");
        ImageView profilePreview = new ImageView();
        profilePreview.setFitWidth(100);
        profilePreview.setFitHeight(100);
        Circle clip = new Circle(50, 50, 50);
        profilePreview.setClip(clip);

        final File[] profileImageFile = new File[1];
        uploadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            profileImageFile[0] = fileChooser.showOpenDialog(stage);
            if (profileImageFile[0] != null) {
                Image img = new Image(profileImageFile[0].toURI().toString());
                profilePreview.setImage(img);
            }
        });
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            String nickname = nicknameField.getText();
            String fullName = fullNameField.getText();
            Image profileImage = profilePreview.getImage();

            if (nickname.isEmpty() || fullName.isEmpty() || profileImage == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Form Tidak Lengkap");
                alert.setHeaderText(null);
                alert.setContentText("Semua field dan foto profil harus diisi sebelum registrasi.");
                alert.showAndWait();
                return;
            }

            currentUser = new User(nickname, fullName, profileImage);
            showHomeScene(stage);
        });

        root.getChildren().addAll(nicknameField, fullNameField, uploadButton, profilePreview, registerButton);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Register - MyMoment");
        stage.show();
    }

    private void showHomeScene(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);

        ImageView profileView = new ImageView(currentUser.getProfileImage());
        profileView.setFitWidth(100);
        profileView.setFitHeight(100);
        Circle clip = new Circle(50, 50, 50);
        profileView.setClip(clip);

        VBox userInfo = new VBox(5);
        Label nickLabel = new Label(currentUser.getNickName());
        nickLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label fullNameLabel = new Label(currentUser.getFullName());
        nickLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Button addPostButton = new Button("Add Post");
        addPostButton.setOnAction(e -> showAddPostWindow(stage));

        userInfo.getChildren().addAll(nickLabel, fullNameLabel, addPostButton);


        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        header.getChildren().addAll(profileView, userInfo, spacer);

        postContainer = new GridPane();
        postContainer.setPadding(new Insets(50));
        postContainer.setHgap(50); // jarak horizontal antar gambar
        postContainer.setVgap(60); // jarak vertikal antar gambar
        postContainer.setAlignment(Pos.CENTER_LEFT);


        ScrollPane scrollPane = new ScrollPane(postContainer);
        scrollPane.setFitToWidth(true);

        root.setTop(header);
        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Home - MyMoment");
        stage.show();
    }

    private void showAddPostWindow(Stage owner) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);q
        stage.initOwner(owner);

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Button uploadButton = new Button("Upload Image");
        ImageView preview = new ImageView();
        preview.setFitWidth(200);
        preview.setFitHeight(200);

        final File[] imageFile = new File[1];
        uploadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            imageFile[0] = fileChooser.showOpenDialog(stage);
            if (imageFile[0] != null) {
                Image img = new Image(imageFile[0].toURI().toString());
                preview.setImage(img);
            }
        });

        TextField captionField = new TextField();
        captionField.setPromptText("Caption");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            if (preview.getImage() != null && !captionField.getText().isEmpty()) {
                Post post = new Post(preview.getImage(), captionField.getText());
                addPostToHome(post);
                stage.close();
            }
        });

        root.getChildren().addAll(uploadButton, preview, captionField, submitButton);

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.setTitle("Add New Post");
        stage.show();
    }

    private void addPostToHome(Post post) {
        StackPane postPane = new StackPane();

        // Gambar postingan
        ImageView imageView = new ImageView(post.getPostImage());
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        // Overlay abu-abu transparan, disembunyikan awalnya
        Rectangle overlay = new Rectangle(200, 200, Color.rgb(0, 0, 0, 0.6));
        overlay.setOpacity(0); // tidak terlihat awalnya

        // Stack untuk gambar + overlay
        StackPane imageStack = new StackPane(imageView, overlay);

        // Label untuk caption, disembunyikan awalnya
        Label captionLabel = new Label(post.getCaption());
        captionLabel.setTextFill(Color.WHITE);
        captionLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        captionLabel.setEffect(new DropShadow(5, Color.BLACK));
        captionLabel.setOpacity(0);

        // Gabungan gambar dan overlay dalam 1 group untuk scaling
        Group hoverGroup = new Group(imageStack);

        // Animasi scaling
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(80), hoverGroup);
        scaleIn.setToX(1.4);
        scaleIn.setToY(1.4);
        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(80), hoverGroup);
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);

        // Animasi muncul/hilang caption
        FadeTransition fadeInText = new FadeTransition(Duration.millis(80), captionLabel);
        fadeInText.setToValue(1.0);
        FadeTransition fadeOutText = new FadeTransition(Duration.millis(80), captionLabel);
        fadeOutText.setToValue(0.0);

        // Animasi overlay
        FadeTransition fadeInOverlay = new FadeTransition(Duration.millis(80), overlay);
        fadeInOverlay.setToValue(0.6);
        FadeTransition fadeOutOverlay = new FadeTransition(Duration.millis(80), overlay);
        fadeOutOverlay.setToValue(0.0);

        // Event ketika mouse masuk
        postPane.setOnMouseEntered(e -> {
            scaleIn.playFromStart();
            fadeInText.playFromStart();
            fadeInOverlay.playFromStart();
        });

        // Event ketika mouse keluar
        postPane.setOnMouseExited(e -> {
            scaleOut.playFromStart();
            fadeOutText.playFromStart();
            fadeOutOverlay.playFromStart();
        });

        // Event klik dua kali
        postPane.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                showImagePreview(post.getPostImage());
            }
        });

        // Gabungkan komponen ke postPane
        postPane.getChildren().addAll(hoverGroup, captionLabel);
        StackPane.setAlignment(captionLabel, Pos.CENTER);

        // Tambahkan ke grid berdasarkan urutan
        int col = postCount % 3;
        int row = postCount / 3;
        postContainer.add(postPane, col, row);
        postCount++;
    }

    private void showImagePreview(Image image) {
        Stage stage = new Stage();
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);

        StackPane pane = new StackPane(imageView);
        Scene scene = new Scene(pane, 520, 520);
        stage.setScene(scene);
        stage.setTitle("Image Preview");
        stage.show();
    }
}