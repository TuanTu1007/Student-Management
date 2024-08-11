package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Dao.infoClassDao;
import Dao.searchStudentDao;
import Model.Lop;
import Model.TraCuuHocSinh;

@WebServlet("/searchStudentServlet")
public class searchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private searchStudentDao SearchStudentDao;
	private infoClassDao InfoClassDao;
	@Resource(name="jdbc/student_management")
	private DataSource datasource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		SearchStudentDao = new searchStudentDao(datasource);
		InfoClassDao = new infoClassDao(datasource);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {
		case "/searchByName":
			try {
				selectStudentByName(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				renderClass(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void renderClass(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		List<Lop> DSL = InfoClassDao.selectAllClass();
		request.setAttribute("DSL", DSL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/searchStudent.jsp");
		dispatcher.forward(request, response);
	}

	private void selectStudentByName(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String name = request.getParameter("search-student-name");
		String nameClass = request.getParameter("search-student-class");
		List<TraCuuHocSinh> DSTCHS = SearchStudentDao.selectStudent(name, nameClass);
		request.setAttribute("DSTCHS", DSTCHS);
		request.setAttribute("searchStudentName", name);
		request.setAttribute("searchStudentClass", nameClass);
		if (DSTCHS.isEmpty()) {
		    request.setAttribute("messageerror", "Không tìm thấy học sinh.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/searchStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
