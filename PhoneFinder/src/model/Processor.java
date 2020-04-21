package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="processor")
public class Processor {
private int ID_Processor;
private String Processor_Name;
public Processor() {}
public Processor(int iD_Processor, String processor_Name) {
	super();
	ID_Processor = iD_Processor;
	Processor_Name = processor_Name;
}

public Processor(String processor_Name) {
	super();
	Processor_Name = processor_Name;
}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="ID_Processor")
public int getID_Processor() {
	return ID_Processor;
}
public void setID_Processor(int iD_Processor) {
	ID_Processor = iD_Processor;
}
public String getProcessor_Name() {
	return Processor_Name;
}
public void setProcessor_Name(String processor_Name) {
	Processor_Name = processor_Name;
}
@Override
public String toString() {
	return Processor_Name;
}








}
