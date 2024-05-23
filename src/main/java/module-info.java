module com.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.schoolmanager to javafx.fxml;
    exports com.example.schoolmanager;
}