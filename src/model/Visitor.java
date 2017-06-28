package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VISITOR database table.
 * 
 */
@Entity
@NamedQuery(name="Visitor.findAll", query="SELECT v FROM Visitor v")
public class Visitor implements Serializable,IModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
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

	@Override
	public String[] getTableHeaders() {
		return new String[]{"Id","FIO","PASSPORT","PhoneNumb","email",};
	}

	@Override
	public Object[] getTableRowData() {
		return new Object[]{id,fiovis, passport,phonenumb,email};
	}

	@Override
	public void updateWith(Object mask) {
		Visitor obj = (Visitor) mask;
		fiovis = obj.getFiovis();
		passport = obj.getPassport();
		phonenumb = obj.getPhonenumb();
		email = obj.getEmail();
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fiovis == null) ? 0 : fiovis.hashCode());
		result = prime * result + id;
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + ((phonenumb == null) ? 0 : phonenumb.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fiovis == null) {
			if (other.fiovis != null)
				return false;
		} else if (!fiovis.equals(other.fiovis))
			return false;
		if (id != other.id)
			return false;
		if (passport == null) {
			if (other.passport != null)
				return false;
		} else if (!passport.equals(other.passport))
			return false;
		if (phonenumb == null) {
			if (other.phonenumb != null)
				return false;
		} else if (!phonenumb.equals(other.phonenumb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", email=" + email + ", fiovis=" + fiovis + ", passport=" + passport
				+ ", phonenumb=" + phonenumb + "]";
	}
	

}