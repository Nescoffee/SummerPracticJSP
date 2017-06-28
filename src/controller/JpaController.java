package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.IModel;
import model.Room;

public class JpaController implements IController{

	
	EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("MyJpaProject");
	
	
	public List getObjectList(Class clazz) {
		EntityManager em = emf.createEntityManager();
		// Формуємо ім'я іменованого запиту для заданого класу
		String queryName = clazz.getSimpleName() + "." + "findAll";
		// Отримуємо перелік записів таблиці заданого класу
		List list = em.createNamedQuery(queryName).getResultList();
		em.close();
		return list;
	}

	
	
	

	
	

	@Override
	public void createDB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TableModel getModel(String className) {
		try {
			Class clazz = Class.forName("model." + className);
			// Отримуємо заголовок таблиці
			IModel obj = (IModel) clazz.newInstance();
			String[] header = obj.getTableHeaders();
			// Отримуємо список об'єктів
			List list = getObjectList(clazz);
			if (list == null || list.size() == 0)
				return new DefaultTableModel(null, header);
			// Створюємо масив потрібного розміру
			Object[][] array = new Object[list.size()][header.length];
			// Наповнюємо масив
			int i = 0;
			for (Object s : list)
				array[i++] = ((IModel) s).getTableRowData();
			// Повертаємо модель
			return new DefaultTableModel(array, header);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void add(Object obj) {
		if(exist((IModel) obj)) return;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpaProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
	em.getTransaction().commit();
	
}


	@Override
	public void edit(int id, Object obj) {
		Class clazz = obj.getClass();
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Object updObj = em.find(clazz, id);
			((IModel) updObj).updateWith(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}


	
	
	
	
	@Override
	public void delete(int id, String className) {
		EntityManager em = emf.createEntityManager();
		try {
			Class clazz = Class.forName("model." + className);
			Object delObj = em.find(clazz, id);
			em.getTransaction().begin();
			em.remove(delObj);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}


	@Override
	public TableModel doQuery1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpaProject");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select r from Room r where r.roomNumb = ?1");
		q.setParameter(1, 101);
		List<Room> list = q.getResultList();
		String[][] arr = new String[list.size()][4];
		int i = 0;
		for (Room r : list) {
			arr[i][0] = String.valueOf(r.getRoomNumb());
			arr[i][1] = String.valueOf(r.getPrice());
			arr[i][2] = r.getType();
			arr[i++][3] = String.valueOf(r.getCountPers());
		}
		DefaultTableModel model = new DefaultTableModel(arr,
	 new String[] { "RoomNumber", "price", "type", "count_of_pers" });
		return model;
	}

	
	
	public boolean exist(IModel obj) {
		Class clazz = obj.getClass();
		// Отримуємо перелік записів таблиці заданого класу
		List list = getObjectList(clazz);
		if (list != null && list.size() != 0)
			for (Object current : list)
				if (current.equals(obj))
					return true;
		return false;
	}

	
	
	
	

	
}
