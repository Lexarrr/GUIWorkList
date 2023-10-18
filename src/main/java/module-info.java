module com.example.guiworklist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guiworklist to javafx.fxml;
    exports com.example.guiworklist;
}