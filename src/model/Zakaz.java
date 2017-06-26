package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ZAKAZ database table.
 * 
 */
@Entity
@NamedQuery(name="Zakaz.findAll", query="SELECT z FROM Zakaz z")
public class Zakaz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_IN")
	private Date dateIn;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OUT")
	private Date dateOut;

	//bi-directional many-to-one association to Manager
	@OneToMany(mappedBy="zakaz")
	private List<Manager> managers;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="ID_ROOM")
	private Room room;

	//bi-directional many-to-one association to Visitor
	@ManyToOne
	@JoinColumn(name="ID_VISITOR")
	private Visitor visitor;

	public Zakaz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateIn() {
		return this.dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return this.dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public List<Manager> getManagers() {
		return this.managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public Manager addManager(Manager manager) {
		getManagers().add(manager);
		manager.setZakaz(this);

		return manager;
	}

	public Manager removeManager(Manager manager) {
		getManagers().remove(manager);
		manager.setZakaz(null);

		return manager;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Visitor getVisitor() {
		return this.visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

}