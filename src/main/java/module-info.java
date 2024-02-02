module com.example.chromread_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.commons.lang3;
    requires org.knowm.xchart;
    requires java.desktop;
    requires javafx.swing;

    opens com.example.chromread_2 to javafx.fxml;
    exports com.example.chromread_2;
}