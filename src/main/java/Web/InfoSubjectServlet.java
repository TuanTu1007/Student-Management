package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Dao.infoSubjectDao;
import Model.Mon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoSubjectServlet")
public class InfoSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private infoSubjectDao InfoSubjectDao;
	@Resource(name="jdbc/student_management")
	private DataSource datasource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		InfoSubjectDao = new infoSubjectDao(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {
		case "/insert":
			try {
				insertSubject(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				e.printStackTrace();
			} 
			break;
			
		case "/update":
            try {
                updateSubject(request, response);
            } catch (ClassNotFoundException | ServletException | IOException e) {
                e.printStackTrace();
            }
            break;
            
		case "/delete":
			try {
				deleteSubject(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
		
		default:
			try {
				render(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				e.printStackTrace();
			}
			break;
		}
		
	}
	
	private void render(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		List<Mon> DSMH = InfoSubjectDao.selectAllSubject();
		request.setAttribute("DSMH", DSMH);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subject.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertSubject(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		String name = request.getParameter("subjectName");
		String heSo = request.getParameter("heSo");
		if(name==null) {
			name = "";
		}
		if(heSo == null) {
			heSo = "1";
		}
		
		Mon m = new Mon(null, name, Integer.parseInt(heSo));
		boolean isvalid = InfoSubjectDao.insertMon(m);
		if (isvalid) {
	        request.setAttribute("messageInfoAddSubject", "Thêm môn mới thành công.");
	    } else {
	        request.setAttribute("messageErrorAddSubject", "Tên môn bị trùng");
	    }
		List<Mon> DSMH = InfoSubjectDao.selectAllSubject();
		request.setAttribute("DSMH", DSMH);
		request.getRequestDispatcher("/subject.jsp").forward(request, response);
	}
	
	private void updateSubject(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		String nameSubjectOld = request.getParameter("nameOld");
		String nameSubject = request.getParameter("name");
		int numberSubject =Integer.parseInt(request.getParameter("number"));
		Mon mon = new Mon(null, nameSubject,numberSubject);
		boolean isvalid = InfoSubjectDao.updateSubject(mon, nameSubjectOld);

	    if (isvalid) {
	        request.setAttribute("messageInfoUpdateSubject", "Sửa tên môn thành công.");
	    } else {
	        request.setAttribute("messageErrorUpdateSubject", "Tên môn đã tồn tại.");
	    }
	    List<Mon> DSMH = InfoSubjectDao.selectAllSubject();
		request.setAttribute("DSMH", DSMH);
	    request.getRequestDispatcher("/subject.jsp").forward(request, response);
	}
	
	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		String nameSubject = request.getParameter("nameRemove");
		boolean isvalid = InfoSubjectDao.deleteSubject(nameSubject);

	    if (isvalid) {
	        request.setAttribute("messageInfoDeleteSubject", "Xoá môn không có dữ liệu thành công.");
	    } else {
	        request.setAttribute("messageErrorDeleteSubject", "Không thể xóa môn đang học.");
	    }
	    List<Mon> DSMH = InfoSubjectDao.selectAllSubject();
		request.setAttribute("DSMH", DSMH);
	    request.getRequestDispatcher("/subject.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doGet(request, response);
	}

}
