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
import Dao.listStudentOfClassDao;
import Model.HocSinh;
import Model.LoaiHinhKiemTra;
import Model.Lop;
import Model.Mon;

@WebServlet("/listStudentOfClassServlet")
public class listStudentOfClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private listStudentOfClassDao ListStudentOfClassDao;
	private infoClassDao InfoClassDao;
	private infoSubjectDao InfoSubjectDao;
	@Resource(name = "jdbc/student_management")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		ListStudentOfClassDao = new listStudentOfClassDao(datasource);
		InfoClassDao = new infoClassDao(datasource);
		InfoSubjectDao = new infoSubjectDao(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {

		case "/show":
			try {
				renderStudentOfClass(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/addStdNotClass":
			try {
				insertStdNotClassToClass(request, response);

			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			try {
				renderClass(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}	

	}
	
	private void renderClass(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		List<Lop> DSL = InfoClassDao.selectAllClass();
		request.setAttribute("DSL", DSL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listStudentOfClass.jsp");
		dispatcher.forward(request, response);
	}

	private void renderStudentOfClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		String className = request.getParameter("search-lop");
		List<HocSinh> DSHS = ListStudentOfClassDao.renderStudentOfClass(className);
		int SiSo = ListStudentOfClassDao.selectSiSo(className);
		List<HocSinh> DSHSNotClass = ListStudentOfClassDao.listStudenNotClass();
		List<Lop> DSL = InfoClassDao.selectAllClass();
		request.setAttribute("DSL", DSL);
		request.setAttribute("DSHSNotClass", DSHSNotClass);
		request.setAttribute("HS", DSHS);
		request.setAttribute("siso", SiSo);
		request.setAttribute("searchClass", className);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listStudentOfClass.jsp");
		dispatcher.forward(request, response);
	}

	private void insertStdNotClassToClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		String className = request.getParameter("className");
		String listEmailOfStdNotClass = request.getParameter("listStudentNotClass");
		String[] emailSplit = ListStudentOfClassDao.splitStringByComma(listEmailOfStdNotClass);
		String[] stdIdList = ListStudentOfClassDao.selectStdIDByEmail(emailSplit);
		List<Mon> DSMH = InfoSubjectDao.selectAllSubject();
		List<LoaiHinhKiemTra> DSLHKT = InfoSubjectDao.selectLHKT();

		boolean isvalid = ListStudentOfClassDao.addStdNotClassToClass(stdIdList, className);
		ListStudentOfClassDao.createTablePointEmpty(stdIdList, className, DSMH);
		ListStudentOfClassDao.createCTTablePointEmpty(stdIdList, DSMH);
		ListStudentOfClassDao.createCTLHKTEmpty(stdIdList, DSMH, DSLHKT);

		if (isvalid) {
			request.setAttribute("messageInfoInsertToClass", "Thêm học sinh vào lớp thành công.");
		} else {
			request.setAttribute("messageErrorInsertToClass",
					"Thêm học sinh thất bại.");
		}
		List<HocSinh> DSHS = ListStudentOfClassDao.renderStudentOfClass(className);
		int SiSo = ListStudentOfClassDao.selectSiSo(className);
		List<HocSinh> DSHSNotClass = ListStudentOfClassDao.listStudenNotClass();
		List<Lop> DSL = InfoClassDao.selectAllClass();
		request.setAttribute("DSL", DSL);
		request.setAttribute("DSHSNotClass", DSHSNotClass);
		request.setAttribute("HS", DSHS);
		request.setAttribute("siso", SiSo);
		request.setAttribute("searchClass", className);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listStudentOfClass.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
