package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phone")
public class Phone {
	
	
private int ID;
private  Brand brand;
private Type type;
private Camera camera;
private Processor processor;


  public Phone(){
	  
  }
public Phone(int iD, Brand brand, Type type, Camera camera, Processor processor) {
	super();
	ID = iD;
	this.brand = brand;
	this.type = type;
	this.camera = camera;
	this.processor = processor;
}

public Phone(Brand brand, Type type, Camera camera, Processor processor) {
	super();
	this.brand = brand;
	this.type = type;
	this.camera = camera;
	this.processor = processor;
}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="ID")
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
@ManyToOne(cascade = CascadeType.ALL)
public  Brand getBrand() {
	return brand;
}
public void setBrand(Brand brand) {
	this.brand = brand;
}
@ManyToOne(cascade = CascadeType.ALL)
public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}
@ManyToOne(cascade = CascadeType.ALL)
public Camera getCamera() {
	return camera;
}
public void setCamera(Camera camera) {
	this.camera = camera;
}
@ManyToOne(cascade = CascadeType.ALL)
public Processor getProcessor() {
	return processor;
}
public void setProcessor(Processor processor) {
	this.processor = processor;
}




}
