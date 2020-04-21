package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="camera")
public class Camera {
	
	
	private int ID_Camera;
	private String Camera_Name;
	
	
	public Camera() {}
	public Camera(int iD_Camera, String camera_Name) {
		super();
		ID_Camera = iD_Camera;
		Camera_Name = camera_Name;
	}
	public Camera(String camera_Name) {
		super();
		Camera_Name = camera_Name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Camera")
	public int getID_Camera() {
		return ID_Camera;
	}
	public void setID_Camera(int iD_Camera) {
		ID_Camera = iD_Camera;
	}
	public String getCamera_Name() {
		return Camera_Name;
	}
	public void setCamera_Name(String camera_Name) {
		Camera_Name = camera_Name;
	}
	@Override
	public String toString() {
		return Camera_Name;
	}
	
	
	
}
