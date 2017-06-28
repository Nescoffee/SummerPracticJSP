package model;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * The persistent class for the ROOM database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable,IModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(name="COUNT_PERS")
	private int countPers;

	private int price;

	@Column(name="ROOM_NUMB")
	private int roomNumb;

	private String type;

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

	@Override
	public String[] getTableHeaders() {
		return new String[]{"Id","CountPers","Price","RoomNumb","Type"};
	}

	@Override
	public Object[] getTableRowData() {
		return new Object[]{id,countPers, price,roomNumb,type};
	}

	@Override
	public void updateWith(Object mask) {
		Room obj = (Room) mask;
		countPers = obj.getCountPers();
		price = obj.getPrice();
		roomNumb = obj.getRoomNumb();
		type = obj.getType();
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countPers;
		result = prime * result + id;
		result = prime * result + price;
		result = prime * result + roomNumb;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Room other = (Room) obj;
		if (countPers != other.countPers)
			return false;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (roomNumb != other.roomNumb)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", countPers=" + countPers + ", price=" + price + ", roomNumb=" + roomNumb + ", type="
				+ type + "]";
	}

}