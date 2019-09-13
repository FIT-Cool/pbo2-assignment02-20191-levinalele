package com.levina.controller;

import com.levina.entity.Category;
import com.levina.entity.Item;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/*
* Author by Anastasia Levina
* 1772020
* */
public class MainFormController implements Initializable {


    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button btnUpdate;
    @FXML
    private ComboBox<Category> cmbxCategory;
    @FXML
    private TextField txtCategoryName;
    @FXML
    private TableColumn<Item,String> colName;
    @FXML
    private TableColumn<Item,Double> colPrice;
    @FXML
    private TableColumn<Item,String> colCategory;
    private ObservableList<Category> categories;
    private ObservableList<Item> items;
    @FXML
    private TableView<Item> tableDepartment;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnRiset;
    @FXML
    private Button btnSaveCategory;

    public void saveAction(ActionEvent actionEvent) {
        Alert x = new Alert(Alert.AlertType.ERROR);
        if(txtName.getText()==null || txtPrice.getText()==null || cmbxCategory.getValue()==null){
            x.setContentText("Tolong isi nama ,harga ,dan categorynya");
            x.showAndWait();
        }
        else {
            int hitung = (int) items.stream().filter(p -> p.getName().equalsIgnoreCase(txtName.getText())).count();
            if (hitung >= 1) {
                x.setContentText("Nama nya sudah ada");
                x.showAndWait();
            } else {
                Item i = new Item();
                i.setName(txtName.getText());
                i.setPrice(Double.valueOf(txtPrice.getText()));
                i.setCategory(cmbxCategory.getValue());
                items.add(i);
            }
        }
    }

    public void risetAction(ActionEvent actionEvent) {
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        txtName.clear();
        txtPrice.clear();
        cmbxCategory.setValue(null);

    }

    public void updateAction(ActionEvent actionEvent) {
        Item i = tableDepartment.getSelectionModel().getSelectedItem();
        i.setCategory(cmbxCategory.getValue());
        i.setName(txtName.getText());
        i.setPrice(Double.parseDouble(txtPrice.getText()));
        tableDepartment.refresh();
    }

    public void savecategoryAction(ActionEvent actionEvent) {

        Alert x = new Alert(Alert.AlertType.ERROR);
        if(txtCategoryName.getText().isEmpty()){
            x.setContentText("Tolong isi category namenya");
            x.showAndWait();
        }
        else {
                Category c = new Category();
                c.setName(txtCategoryName.getText().trim());
                int hitung=(int) categories.stream().filter(p-> p.getName().equalsIgnoreCase(txtCategoryName.getText().trim())).count();
                if (hitung>=1){
                    x.setContentText("Kategori terduplikat");
                    x.showAndWait();
                }
                else {
                    categories.add(c);
                    txtCategoryName.clear();
                }

            }
        }


    public void tableClicked(MouseEvent mouseEvent) {
        Item i = tableDepartment.getSelectionModel().getSelectedItem();
        txtName.setText(i.getName());
        txtPrice.setText(String.valueOf(i.getPrice()));
        cmbxCategory.setValue(i.getCategory());
        btnSave.setDisable(true);
        btnUpdate.setDisable(false);
    }

    public void closeAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void aboutAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categories = FXCollections.observableArrayList();
        items = FXCollections.observableArrayList();
        cmbxCategory.setItems(categories);
        tableDepartment.setItems(items);
        colName.setCellValueFactory(data->{
            Item i = data.getValue();
            return new SimpleStringProperty(i.getName());
        });
        colPrice.setCellValueFactory(data->{
            Item i = data.getValue();
            return new SimpleDoubleProperty(i.getPrice()).asObject();        });
        colCategory.setCellValueFactory(data-> {
            Item i = data.getValue();
            return new SimpleStringProperty(i.getCategory().getName());
        });
    }
}
