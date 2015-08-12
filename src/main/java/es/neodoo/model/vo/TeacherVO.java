package es.neodoo.model.vo;

public class TeacherVO {
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	
	public TeacherVO(int id , String nombre, String apellidos , String dni) {
		this.id= id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni=dni;
	}
	

	public void setid(int id) {
		this.id = id;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getid() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}
	
	public String getDni() {
		return dni;
	}
	
	
	

}
