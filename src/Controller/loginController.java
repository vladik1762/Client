package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.company.Animation.Shake;
import com.company.AdapterToClient;
import com.company.ClientSomthing;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.DoubleValidator;
import com.jfoenix.validation.RegexValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPaneLog;

    @FXML
    private JFXTextField loginFieldForLog;

    @FXML
    private JFXPasswordField passwordFieldForLog;

    @FXML
    private JFXButton registrationButton;

    @FXML
    private AnchorPane anchorPaneReg;

    @FXML
    private JFXTextField nameFieldForReg;

    @FXML
    private JFXTextField emailFieldForReg;

    @FXML
    private JFXPasswordField passwordFieldForReg;

    @FXML
    private JFXPasswordField passwordRepeatFieldForReg;

    @FXML
    private JFXTextField loginFieldForReg;

    @FXML
    private JFXButton regButtonForReg;

    @FXML
    private JFXButton sigInButtonForLog;

    @FXML
    void initialize() {

        ClientSomthing cl = AdapterToClient.get();

        checkInputForRegUser();

        registrationButton.setOnAction(actionEvent -> {
            anchorPaneReg.toFront();
        });

        regButtonForReg.setOnAction(actionEvent -> {
            registrationUser(cl);

        });

        sigInButtonForLog.setOnAction(actionEvent -> {
            sigInUser(cl);
        });
    }


    public void checkInputForRegUser() {

        DoubleValidator doubleValidator = new DoubleValidator();
        RegexValidator regexValidator = new RegexValidator();
        RegexValidator regexValidatorForEmail = new RegexValidator();


        doubleValidator.setMessage("Недопустимые символы");
        regexValidator.setRegexPattern("^[а-яА-ЯёЁa-zA-Z ]{0,20}");
        regexValidator.setMessage("Недопустимые символы");
        regexValidatorForEmail.setMessage("Недопустимые символы");

        regexValidatorForEmail.setRegexPattern("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");


        nameFieldForReg.getValidators().add(regexValidator);
        nameFieldForReg.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (!newValue) {

                    nameFieldForReg.validate();
                }
            }
        });


        emailFieldForReg.getValidators().add(regexValidatorForEmail);
        emailFieldForReg.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (!newValue) {

                    emailFieldForReg.validate();
                }
            }
        });


    }

    public void registrationUser(ClientSomthing cl) {


        String firstName;
        String email;
        String userName;
        String password;
        String passwordRepeat;


        firstName = nameFieldForReg.getText().trim();
        email = emailFieldForReg.getText().trim();
        userName = loginFieldForReg.getText().trim();
        password = passwordFieldForReg.getText().trim();
        passwordRepeat = passwordRepeatFieldForReg.getText().trim();


        if (firstName.equals("")) {
            Shake userFirstName = new Shake(nameFieldForReg);
            userFirstName.playAnim();
        } else if (email.equals("")) {
            Shake userEmail = new Shake(emailFieldForReg);
            userEmail.playAnim();
        } else if (userName.equals("")) {
            Shake userUserName = new Shake(loginFieldForReg);
            userUserName.playAnim();
        } else if (password.equals("")) {
            Shake userPassword = new Shake(passwordFieldForReg);
            userPassword.playAnim();
        } else if (passwordRepeat.equals("")) {
            Shake userPasswordRepeat = new Shake(passwordRepeatFieldForReg);
            userPasswordRepeat.playAnim();
        } else if (!passwordRepeat.equals(password)) {

            Shake userPassword = new Shake(passwordFieldForReg);
            userPassword.playAnim();
            Shake userPasswordRepeat = new Shake(passwordRepeatFieldForReg);
            userPasswordRepeat.playAnim();


        } else {


            String resIsValue = cl.isUserName(userName);

            if (resIsValue.equals("Совпадение")) {

                Shake userUserName = new Shake(loginFieldForReg);
                userUserName.playAnim();
            } else {
                String str = cl.sendDataForRegistration("Регистрация", firstName, userName, password, email);
                JOptionPane.showMessageDialog(null, "Поздравляем! Вы зарегистрированы.");
                anchorPaneLog.toFront();

            }
        }


    }

    public void sigInUser(ClientSomthing cl) {


        String login = loginFieldForLog.getText().trim();   // trim() - убирает лишние пробелы
        String password = passwordFieldForLog.getText().trim();


        String path = "";
        if (!login.equals("") && !password.equals("")) {
            String str;
            cl.sendDataForSignIn("Авторизация", login, password);
            str = cl.getStr();
            if (str.equals("Успешно")) {

//
               sigInButtonForLog.getScene().getWindow().hide();

                path = "/FXMLFile/menu.fxml";



            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(path));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();

        } else {

            passwordFieldForLog.clear();
            loginFieldForLog.clear();

                Shake userNameAnim = new Shake(loginFieldForLog);
                Shake userPassAnim = new Shake(passwordFieldForLog);
                userNameAnim.playAnim();
                userPassAnim.playAnim();
        }
        }
        else{
            Shake userNameAnim = new Shake(loginFieldForLog);
            Shake userPassAnim = new Shake(passwordFieldForLog);
            userNameAnim.playAnim();
            userPassAnim.playAnim();

        }
    }






}






