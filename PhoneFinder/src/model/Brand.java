package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class Brand {
private int ID_Brand;
private String Brand_Name;



public Brand() {}
public Brand(int iD_Brand, String brand_Name) {
	super();
	ID_Brand = iD_Brand;
	Brand_Name = brand_Name;
}
public Brand(String brand_Name) {
	super();
	Brand_Name = brand_Name;
}


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="ID_Brand")
public int getID_Brand() {
	return ID_Brand;
}
public void setID_Brand(int iD_Brand) {
	ID_Brand = iD_Brand;
}
public String getBrand_Name() {
	return Brand_Name;
}
public void setBrand_Name(String brand_Name) {
	Brand_Name = brand_Name;
}
@Override
public String toString() {
	return  Brand_Name;
}



}
