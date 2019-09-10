package com.levina.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class MainFormController implements Initializable {

    public TextField txtPrice;
    public ComboBox cmbxCategory;
    public Button btnUpdate;
    public TextField txtCategoryName;
    public TableColumn colName;
    public TableColumn colPrice;
    public TableColumn colCategory;
    public TextField txtName;


    public void saveAction(ActionEvent actionEvent) {
    }

    public void risetAction(ActionEvent actionEvent) {
    }

    public void updateAction(ActionEvent actionEvent) {
    }

    public void savecategoryAction(ActionEvent actionEvent) {
    }

    public void tableClicked(MouseEvent mouseEvent) {
    }

    public void closeAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void aboutAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
