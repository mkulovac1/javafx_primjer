module ba.unsa.etf.rpr.javafx_primjer {
    requires javafx.controls;
    requires javafx.fxml;


    opens ba.unsa.etf.rpr.javafx_primjer to javafx.fxml;
    exports ba.unsa.etf.rpr.javafx_primjer;
}