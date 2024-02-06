module com.example.mortgageplan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mortgageplan to javafx.fxml;
    exports com.example.mortgageplan;
}