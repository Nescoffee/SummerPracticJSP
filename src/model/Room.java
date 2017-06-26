package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROOM database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="COUNT_PERS")
	private int countPers;

	private int price;

	@Column(name="ROOM_NUMB")
	private int roomNumb;

	private String type;

	//bi-directional many-to-one association to Zakaz
	@OneToMany(mappedBy="room")
	private List<Zakaz> zakazs;

	public Room() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountPers() {
		return this.countPers;
	}

	public void setCountPers(int countPers) {
		this.countPers = countPers;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRoomNumb() {
		return this.roomNumb;
	}

	public void setRoomNumb(int roomNumb) {
		this.roomNumb = roomNumb;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Zakaz> getZakazs() {
		return this.zakazs;
	}

	public void setZakazs(List<Zakaz> zakazs) {
		this.zakazs = zakazs;
	}

	public Zakaz addZakaz(Zakaz zakaz) {
		getZakazs().add(zakaz);
		zakaz.setRoom(this);

		return zakaz;
	}

	public Zakaz removeZakaz(Zakaz zakaz) {
		getZakazs().remove(zakaz);
		zakaz.setRoom(null);

		return zakaz;
	}

}