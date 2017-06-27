package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MANAGER database table.
 * 
 */
@Entity
@NamedQuery(name="Manager.findAll", query="SELECT m FROM Manager m")
public class Manager implements Serializable,IModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="FIO_MANAGER")
	private String fioManager;

	//uni-directional one-to-one association to Zakaz
	@OneToOne
	@JoinColumn(name="ID_ZAKAZ")
	private Zakaz zakaz;

	public Manager() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFioManager() {
		return this.fioManager;
	}

	public void setFioManager(String fioManager) {
		this.fioManager = fioManager;
	}

	public Zakaz getZakaz() {
		return this.zakaz;
	}

	public void setZakaz(Zakaz zakaz) {
		this.zakaz = zakaz;
	}

	@Override
	public String[] getTableHeaders() {
		return new String[]{"Id","FioManager","Zakaz"};
	}

	@Override
	public Object[] getTableRowData() {
		String z = (zakaz==null)? "null": String.valueOf(zakaz.getId());
		return new Object[]{id,z,fioManager};
	}

	@Override
	public void updateWith(Object mask) {
		Manager obj = (Manager) mask;
		fioManager = obj.getFioManager();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fioManager == null) ? 0 : fioManager.hashCode());
		result = prime * result + id;
		result = prime * result + ((zakaz == null) ? 0 : zakaz.hashCode());
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
		Manager other = (Manager) obj;
		if (fioManager == null) {
			if (other.fioManager != null)
				return false;
		} else if (!fioManager.equals(other.fioManager))
			return false;
		if (id != other.id)
			return false;
		if (zakaz == null) {
			if (other.zakaz != null)
				return false;
		} else if (!zakaz.equals(other.zakaz))
			return false;
		return true;
	}

}