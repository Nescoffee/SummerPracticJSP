package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MANAGER database table.
 * 
 */
@Entity
@NamedQuery(name="Manager.findAll", query="SELECT m FROM Manager m")
public class Manager implements Serializable {
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

}