package es.neodoo.model.vo;

public class UserTeacherVO {
	private int id;
	private int id_user;
	private String centro;
	private String asignatura;
	
	public UserTeacherVO(int id , int id_user, String centro , String asignatura) {
		this.id= id;
		this.id_user= id_user;
		this.centro = centro;
		this.asignatura = asignatura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
}
