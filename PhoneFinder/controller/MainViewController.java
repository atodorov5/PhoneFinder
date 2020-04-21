package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Brand;
import model.Camera;
import model.Processor;
import model.Type;

public class MainViewController {
	@FXML private AnchorPane newCarap= new AnchorPane();
	@FXML private BorderPane mainBP;
	@FXML private AnchorPane Home;
	@FXML private ComboBox<Brand> cbBrand;
	@FXML private ComboBox<Camera> cbCamera;
	@FXML private ComboBox<Type> cbType;
	@FXML private ComboBox<Processor> cbProcessor;
	
	
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
	

}
