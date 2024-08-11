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
import Dao.infoSubjectDao;
import Dao.renderPointAllSubjectDao;
import Dao.tablePointDao;
import Model.Lop;
import Model.Mon;
import Model.PointAllSubject;
import Model.tablePointSubjectClass;

@WebServlet("/renderPointAllSubjectServlet")
public class renderPointAllSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private infoSubjectDao InfoSubjectDao;  
	private infoClassDao InfoClassDao;
	private renderPointAllSubjectDao RenderPointAllSubjectDao;
	
	@Resource(name="jdbc/student_management")
	private DataSource datasource;
       
	@Override
	public void init() throws ServletException {
		super.init();
		InfoSubjectDao = new infoSubjectDao(datasource);
		InfoClassDao = new infoClassDao(datasource);
		RenderPointAllSubjectDao = new renderPointAllSubjectDao(datasource);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {
		case "/pointAllSubject":
			try {
				selectPointAllSubject(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/filter":
			try {
				filterTypeStudents(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | NumberFormatException | SQLException e) {
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
	
	private void selectPointAllSubject(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String tenLop = request.getParameter("search-lop");
		String hocKy = request.getParameter("search-hk");
		if(tenLop==null) {
			tenLop = "";
		}
		if(hocKy == null) {
			hocKy = "1";
		}
		List<PointAllSubject> DSD = RenderPointAllSubjectDao.selectPointAllSubject(tenLop, Integer.parseInt(hocKy));
		List<Lop> DSL = InfoClassDao.selectAllClass();
		request.setAttribute("DSL", DSL);
		request.setAttribute("DSD", DSD);
		request.setAttribute("nameLop", tenLop);
		request.setAttribute("nameHocKy", hocKy);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/renderPointAllSubject.jsp");
		dispatcher.forward(request, response);
	}
	
	private void renderClass(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		List<Lop> DSL = InfoClassDao.selectAllClass();
		request.setAttribute("DSL", DSL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/renderPointAllSubject.jsp");
		dispatcher.forward(request, response);
	}
	
	private void filterTypeStudents(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, NumberFormatException, SQLException {
		String lop = request.getParameter("search-lop");
		String phanLoai = request.getParameter("search-loaiHS");
		System.out.println(lop);
		List<PointAllSubject> type = RenderPointAllSubjectDao.renderTypeStudent(phanLoai);
		request.setAttribute("DSD", type);
		request.setAttribute("loaiHS", phanLoai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/renderPointAllSubject.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
