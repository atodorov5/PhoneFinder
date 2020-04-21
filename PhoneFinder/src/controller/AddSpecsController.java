package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Brand;
import model.Camera;
import model.Processor;
import model.Type;

public class AddSpecsController  implements Initializable{
	
	
	@FXML private TextField brand;
	@FXML private TextField camera;
	@FXML private TextField type;
	@FXML private TextField processor;
	@FXML private Label label;
	@FXML private Slider slider;
	@FXML private Label Sliderlabel;
	
	
	public void addBrand() {
		Session session = model.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String brandText = brand.getText().toString();
        if(!brandText.equals("")) {
        Brand brand1 = new Brand(brandText);
        session.save(brand1);
        label.setText("Успешно добавена марка!");
        brand.clear();
        }
        else {
        label.setText("Неуспешно добавена марка!");
        }
        
        session.getTransaction().commit(); 
	}
	
	public void addCamera() {
		Session session = model.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int txt = (int) slider.getValue();
  
        Camera object = new Camera(txt+" px");
        session.save(object);
        label.setText("Успешно добавена камера!");
        slider.setValue(4);
             
        session.getTransaction().commit(); 
	}
	
	
	public void addType() {
		Session session = model.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String txt = type.getText().toString();
        if(!txt.equals("")) {
        Type object = new Type(txt);
        session.save(object);
        label.setText("Успешно добавен тип!");
        type.clear();
        }
        else {
        label.setText("Неуспешно добавен тип!");
        }
        
        session.getTransaction().commit(); 
	}
	
	public void addProcessor() {
		Session session = model.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String txt = processor.getText().toString();
        if(!txt.equals("")) {
        Processor object = new Processor(txt);
        session.save(object);
        label.setText("Успешно добавен процесор!");
        processor.clear();
        }
        else {
        label.setText("Неуспешно добавен процесор!");
        }
        
        session.getTransaction().commit(); 
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(
               ObservableValue<? extends Number> observableValue, 
               Number oldValue, 
               Number newValue) { 
                  Sliderlabel.textProperty().setValue(
                       String.valueOf(newValue.intValue()+" px"));
              }
        
    });
		
		slider.setMin(4);
		slider.setValue(4);
		slider.setMax(48);
		slider.setBlockIncrement(4);
		
	}
	

}
