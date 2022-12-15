module com.example.exercise_09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercise_09 to javafx.fxml;
    exports com.example.exercise_09;
}