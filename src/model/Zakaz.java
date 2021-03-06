package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ZAKAZ database table.
 * 
 */
@Entity
@NamedQuery(name="Zakaz.findAll", query="SELECT z FROM Zakaz z")
public class Zakaz implements Serializable,IModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_IN")
	private Date dateIn;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OUT")
	private Date dateOut;

	//uni-directional one-to-one association to Visitor
	@OneToOne
	@JoinColumn(name="ID_VISITOR")
	private Visitor visitor;

	//uni-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="ID_ROOM")
	private Room room;

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

	public Visitor getVisitor() {
		return this.visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String[] getTableHeaders() {
		return new String[]{"Id","Number of room","Visitor","date come","date get out"};
	}

	@Override
	public Object[] getTableRowData() {
		String r = (room==null)? "null":String.valueOf(room.getRoomNumb());
		String v = (visitor==null)? "null":visitor.getFiovis();
		return new Object[]{id,r,v,dateIn,dateOut};
	}

	@Override
	public void updateWith(Object mask) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Zakaz [id=" + id + ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", visitor=" + visitor + ", room="
				+ room + "]";
	}
	

}