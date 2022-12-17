module kozmikoda.utilitytoolbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires com.jfoenix;
    requires java.desktop;

    opens kozmikoda.utilitytoolbox to javafx.fxml;
    opens kozmikoda.utilitytoolbox.passwordcase to javafx.fxml;
    opens kozmikoda.utilitytoolbox.mp3player to javafx.fxml;
    opens kozmikoda.utilitytoolbox.cvf.cool_voice_finder_gui to javafx.fxml;
    opens kozmikoda.utilitytoolbox.mainapp to javafx.fxml;

    exports kozmikoda.utilitytoolbox;
    exports kozmikoda.utilitytoolbox.mp3player;
    exports kozmikoda.utilitytoolbox.passwordcase;
    exports kozmikoda.utilitytoolbox.cvf.cool_voice_finder_gui;
    exports kozmikoda.utilitytoolbox.mainapp;
}