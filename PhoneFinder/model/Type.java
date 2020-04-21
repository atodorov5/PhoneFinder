package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type")
public class Type {
	private int ID_Type;
	private String Type_Name;
	public Type() {}
	public Type(int iD_Type, String type_Name) {
		super();
		ID_Type = iD_Type;
		Type_Name = type_Name;
	}
	public Type(String type_Name) {
		super();
		Type_Name = type_Name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Type")
	public int getID_Type() {
		return ID_Type;
	}
	public void setID_Type(int iD_Type) {
		ID_Type = iD_Type;
	}
	public String getType_Name() {
		return Type_Name;
	}
	public void setType_Name(String type_Name) {
		Type_Name = type_Name;
	}
	@Override
	public String toString() {
		return Type_Name;
	}
	
	
	

}
