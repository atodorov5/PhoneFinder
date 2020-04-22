package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Brand;
import model.Camera;
import model.Phone;
import model.Processor;
import model.Type;

public class SearchViewController implements Initializable
{
	
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
		@FXML private TextField tfbrand;
		@FXML private TextField tfcamera;
		@FXML private ImageView photo;
		
		
		
		
		
		FilteredList<Phone> filteredData ;
		 ObservableList<Phone> phonelist;
		public void  TableViewFill() {
			
			Session session = model.HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
		    Query query = session.createQuery("from Phone");
		    phonelist = FXCollections.observableArrayList(query.list());
		    session.getTransaction().commit();
		  
		    tbPhone.setItems(phonelist);
		    
		 
		    filteredData = new FilteredList<Phone>(phonelist, p -> true);
		    
			   
		    
		    
		    tfbrand.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(person -> {
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }

	                String lowerCaseFilter = newValue.toLowerCase();

	                 if (person.getBrand().getBrand_Name().toLowerCase().contains(lowerCaseFilter)) {
	                    return true;
	                }
	                 else if  (person.getCamera().getCamera_Name().toLowerCase().contains(lowerCaseFilter)) {
		                    return true;
		                }
	                 else if (person.getType().getType_Name().toLowerCase().contains(lowerCaseFilter)) {
		                    return true;
		                }
	                 else if (person.getProcessor().getProcessor_Name().toLowerCase().contains(lowerCaseFilter)) {
		                    return true;
		                }
	                return false;
	            });
	         
	            
	        });
		   
		
		    
		        SortedList<Phone> sortedData = new SortedList<>(filteredData);
		        sortedData.comparatorProperty().bind(tbPhone.comparatorProperty());
		        tbPhone.setItems(sortedData);
		        
		        
		    
		}
		
		
		



		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			tcBrand.setCellValueFactory(new PropertyValueFactory<Phone, Brand>("brand"));
			tcCamera.setCellValueFactory(new PropertyValueFactory<Phone, Camera>("camera"));
			tcType.setCellValueFactory(new PropertyValueFactory<Phone, Type>("type"));
			tcProcessor.setCellValueFactory(new PropertyValueFactory<Phone, Processor>("processor"));
			photo.setImage(new Image("search.png"));
			TableViewFill();
			
			
			
		}

	   
		public void cbBrandFill() {
			Session session = model.HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query3 = session.createQuery("from Brand");
			ObservableList<Brand> list3 = FXCollections.observableArrayList(query3.list());
			cbBrand.setItems(list3);
			session.getTransaction().commit();
			
		}
		public void cbCameraFill() {
			Session session = model.HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query3 = session.createQuery("from Camera");
			ObservableList<Camera> list3 = FXCollections.observableArrayList(query3.list());
			cbCamera.setItems(list3);
			session.getTransaction().commit();
			
		}
		public void cbTypeFill() {
			Session session = model.HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query3 = session.createQuery("from Type");
			ObservableList<Type> list3 = FXCollections.observableArrayList(query3.list());
			cbType.setItems(list3);
			session.getTransaction().commit();
			
		}
		public void cbProcessorFIll() {
			Session session = model.HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query3 = session.createQuery("from Processor");
			ObservableList<Processor> list3 = FXCollections.observableArrayList(query3.list());
			cbProcessor.setItems(list3);
			session.getTransaction().commit();
			
		}


	}

