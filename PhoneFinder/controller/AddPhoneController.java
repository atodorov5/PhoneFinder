package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Brand;
import model.Camera;
import model.Phone;
import model.Processor;
import model.Type;

public class AddPhoneController implements Initializable {

	
	@FXML ComboBox<Brand> brandCB;
	@FXML ComboBox<Camera> cameraCB;
	@FXML ComboBox<Type> typeCB;
	@FXML ComboBox<Processor> processorCB;
	
	@FXML Button button;
	@FXML ImageView photo;
	@FXML Label label;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Session session = model.HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Brand");
		ObservableList<Brand> list = FXCollections.observableArrayList(query.list());
		brandCB.setItems(list);
		
		Query query2 = session.createQuery("from Camera");
		ObservableList<Camera> list2 = FXCollections.observableArrayList(query2.list());
		cameraCB.setItems(list2);
		
		Query query3 = session.createQuery("from Type");
		ObservableList<Type> list3 = FXCollections.observableArrayList(query3.list());
		typeCB.setItems(list3);
		
		Query query4 = session.createQuery("from Processor");
		ObservableList<Processor> list4 = FXCollections.observableArrayList(query4.list());
		processorCB.setItems(list4);
		
		photo.setImage(new Image("smartphone.png"));
		
		session.getTransaction().commit();
	}
	
	public void addPhone() {
		
		Session session = model.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Brand brand1 = (Brand) brandCB.getValue();
        Camera camera1 = (Camera) cameraCB.getValue();
        Type type1 = (Type) typeCB.getValue();
        Processor processor1 = (Processor) processorCB.getValue();
        		
        if(!brandCB.getSelectionModel().isEmpty() &&  !cameraCB.getSelectionModel().isEmpty() && !typeCB.getSelectionModel().isEmpty() && !processorCB.getSelectionModel().isEmpty()  ) {
        	
        Phone phone = new Phone(brand1, type1, camera1, processor1);
        session.save(phone);
        label.setText("Успешно добавен телефон!");

        }
        else {
        label.setText("Неуспешно добавен телефон!");
        }
        
        session.getTransaction().commit(); 
	}
	
	
	
	
}
