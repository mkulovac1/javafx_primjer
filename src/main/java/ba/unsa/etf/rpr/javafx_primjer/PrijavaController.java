package ba.unsa.etf.rpr.javafx_primjer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class PrijavaController {

    public TextField fieldUserName;
    public TextField fieldPassword;

    @FXML
    public void initialize() {
        fieldUserName.getStyleClass().add("poljeNijeIspravno");
        fieldUserName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(fieldUserName.getText().isEmpty() || fieldUserName.getText().isBlank()) {
                    fieldUserName.getStyleClass().removeAll("poljeJeIspravno"); // uvijek moras remove
                    fieldUserName.getStyleClass().add("poljeNijeIspravno");
                }
                else {
                    fieldUserName.getStyleClass().removeAll("poljeNijeIspravno"); // uvijek moras remove
                    fieldUserName.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }


    public void btnPrijava(ActionEvent actionEvent) throws IOException {
         if(fieldUserName.getText().isEmpty() || fieldUserName.getText().isEmpty()) {
            fieldUserName.getStyleClass().add("poljeNijeIspravno");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Niste unijeli korisničko ime!");
            alert.setContentText("Korisničko ime ne smije biti prazno!");
            alert.showAndWait();
         }
         else {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("popUp.fxml"));
            Parent root = loader.load();
            PopUpController popUp = loader.getController();
            popUp.labela.setText(popUp.labela.getText() + fieldUserName.getText());
            stage.setTitle("Novi prozor");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
    }
}
