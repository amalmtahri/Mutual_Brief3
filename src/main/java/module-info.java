module com.example.brief3 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	requires gson;
	requires json.simple;
	requires javafx.base;
    opens com.example.brief3 to javafx.fxml;
    exports com.example.brief3;
    exports com.models;
}