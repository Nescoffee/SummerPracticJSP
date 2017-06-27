package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VISITOR database table.
 * 
 */
@Entity
@NamedQuery(name="Visitor.findAll", query="SELECT v FROM Visitor v")
public class Visitor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String fiovis;

	private String passport;

	private String phonenumb;

	public Visitor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFiovis() {
		return this.fiovis;
	}

	public void setFiovis(String fiovis) {
		this.fiovis = fiovis;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPhonenumb() {
		return this.phonenumb;
	}

	public void setPhonenumb(String phonenumb) {
		this.phonenumb = phonenumb;
	}

}