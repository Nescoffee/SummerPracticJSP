package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.table.TableModel;

import controller.JpaController;

import model.Manager;
import model.IModel;
import model.Room;
import model.Visitor;
import model.Zakaz;

/**
 * Servlet implementation class ExecuteOperation
 */
@WebServlet("/ExecuteOperation")
public class ExecuteOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //������
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("doshlo do servlet");
    	HttpSession session = request.getSession();
    	String tableName = (String) session.getAttribute("tableName");
    	JpaController controller = (JpaController) session.getAttribute("controller");
    	String className = "model." + tableName;
    	String operation = (String) session.getAttribute("operation");
    	
    	
    	
    	if (operation.equals("delete")) {
    		int id = Integer.parseInt(request.getParameter("id"));
    		controller.delete(id, tableName);
    	} 
    
    	else  {
    		IModel obj = null;
    		try {
    			obj = (IModel) Class.forName(className).newInstance();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		if (obj instanceof Room) {
    			int roomNumb = Integer.parseInt(request.getParameter("roomNumb"));
    			((Room) obj).setRoomNumb(roomNumb);
    			int price = Integer.parseInt(request.getParameter("price"));
    			((Room) obj).setPrice(price);
    			String type = request.getParameter("type");
    			((Room) obj).setType(type);
    			int countPers = Integer.parseInt(request.getParameter("countPers"));
    			((Room) obj).setCountPers(countPers);
    			
    		}
    	 else if (obj instanceof Visitor) {
			String fiovis = request.getParameter("fiovis");
			((Visitor) obj).setFiovis(fiovis);
			String passport = request.getParameter("passport");
			((Visitor) obj).setPassport(passport);
			String phonenumb = request.getParameter("phonenumb");
			((Visitor) obj).setPhonenumb(phonenumb);
			String email = request.getParameter("email");
			((Visitor) obj).setEmail(email);
			
		}
    		
    	 else if (obj instanceof Manager) {
  			String fioManager = request.getParameter("fioManager");
 			((Manager) obj).setFioManager(fioManager);
 			
 			System.out.println("manager add");
 				Enumeration <String> n = request.getParameterNames();
 				while (n.hasMoreElements()) {
						String string = (String) n.nextElement();
						System.out.println(string);
 				}
 				int id_zakaz = Integer.parseInt(request.getParameter("id_zakaz"));
 				Zakaz roo = (Zakaz)(findById(id_zakaz,controller,"Zakaz"));
 				((Manager) obj).setZakaz(roo);
 				
 			
 		}
    	 else if (obj instanceof Zakaz) {
 			Date dateIn = Date.valueOf(request.getParameter("dateIn"));
 			((Zakaz) obj).setDateIn(dateIn);
 			Date dateOut = Date.valueOf(request.getParameter("dateOut"));
 			((Zakaz) obj).setDateOut(dateOut);
 			System.out.println("zakaz add");
 
 			
 			Enumeration <String> n = request.getParameterNames();
				while (n.hasMoreElements()) {
					String string = (String) n.nextElement();
					System.out.println(string);
				}
				int id_zakaz = Integer.parseInt(request.getParameter("roomId"));
				Room roo = (Room)(findById(id_zakaz,controller,"Room"));
				((Zakaz) obj).setRoom(roo);
				
				int id_vis = Integer.parseInt(request.getParameter("visId"));
				Visitor vis = (Visitor)(findById(id_vis,controller,"Visitor"));
				((Zakaz) obj).setVisitor(vis);
				
			
    	 }
    		
    		
    		switch (operation) {
    		case "edit":
    			int id = Integer.parseInt(request.getParameter("id"));
    			controller.edit(id, obj);
    			break;
    		case "add":
    			System.out.println("doshlo");
    			controller.add(obj);
    			
    		}
    	
    		
			
    		
    	} 
    	
    	TableModel tableModel = controller.getModel(tableName);
    	session.setAttribute("tableModel", tableModel);
    	request.getRequestDispatcher("showTable.jsp").forward(request, response);
    	}
    


    private IModel findById(int id, JpaController controller, String className) {
    	try {
    		IModel obj = null;
    		Class clazz = Class.forName("model."+className);
    		for (Object x : controller.getObjectList(clazz)) {
    			obj = (IModel) x;
    			if (obj.getId() == id)
    				return obj;
    		}
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return null;
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
