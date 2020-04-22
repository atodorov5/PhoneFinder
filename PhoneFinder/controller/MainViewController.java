package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Brand;
import model.Camera;
import model.Phone;
import model.Processor;
import model.Type;

public class MainViewController  implements Initializable {
	@FXML private AnchorPane newCarap= new AnchorPane();
	@FXML private BorderPane mainBP;
	@FXML private AnchorPane Home;
	@FXML private ComboBox<Brand> cbBrand;
	@FXML private ComboBox<Camera> cbCamera;
	@FXML private ComboBox<Type> cbType;
	@FXML private ComboBox<Processor> cbProcessor;
	@FXML private TableView<Phone> tbPhone;
	@FXML private TableColumn<Phone, Brand> tcBrand;
	@FXML private TableColumn<Phone, Camera> tcCamera;
	@FXML private TableColumn<Phone, Type> tcType;
	@FXML private TableColumn<Phone, Processor> tcProcessor;
	
	
	
	
	
	
	@FXML    public void addSpecsMenuItem() throws IOException {
        newCarap.getChildren().clear();
        newCarap.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/controller/AddSpecsView.fxml")));
        mainBP.setCenter(newCarap);
    }
	
	@FXML    public void GoHome() throws IOException {
        mainBP.setCenter(Home);
    }

	@FXML    public void addPhoneMenuItem() throws IOException {
        newCarap.getChildren().clear();
        newCarap.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/controller/AddPhoneView.fxml")));
        mainBP.setCenter(newCarap);
    }
	@FXML    public void searchMenuItem() throws IOException {
        newCarap.getChildren().clear();
        newCarap.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/controller/SearchView.fxml")));
        mainBP.setCenter(newCarap);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			searchMenuItem();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
