module com.kushalgurung.accountbalancecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kushalgurung.accountbalancecalculator to javafx.fxml;
    exports com.kushalgurung.accountbalancecalculator;
}