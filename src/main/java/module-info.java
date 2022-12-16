module kozmikoda.utilitytoolbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires com.jfoenix;

    opens kozmikoda.utilitytoolbox to javafx.fxml;
    exports kozmikoda.utilitytoolbox;
    exports kozmikoda.utilitytoolbox.mp3player;
}