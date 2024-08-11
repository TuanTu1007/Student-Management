package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Dao.infoClassDao;
import Model.HocSinh;
import Model.Lop;
import Model.Mon;
import Model.TraCuuHocSinh;
import Model.TraCuuKhoi;
import Model.updateLop;

@WebServlet("/infoClassServlet")
public class infoClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private infoClassDao InfoClassDao;
	@Resource(name = "jdbc/student_management")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		InfoClassDao = new infoClassDao(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {
		case "/searchByKhoi":
			try {
				selectKhoi(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/insert":
			try {
				insertClass(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateClass(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteClass(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			try {
				request.setAttribute("search-khoi", "Khối 10");
				selectKhoi(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void selectKhoi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String tenKhoi = request.getAttribute("search-khoi") != null ? (String) request.getAttribute("search-khoi")
				: request.getParameter("search-khoi");
		if (tenKhoi == null) {
			tenKhoi = "Khối 10"; 
		}
		List<TraCuuKhoi> DSK = InfoClassDao.selectKhoi(tenKhoi);
		request.setAttribute("DSTCK", DSK);
		request.setAttribute("nameKhoi", tenKhoi);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class.jsp");
		dispatcher.forward(request, response);
	}

	private void insertClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String nameClass = request.getParameter("newClassName");
		String num = request.getParameter("newNumber");
		Lop m = new Lop(null, nameClass, Integer.parseInt(num), null, null);
		boolean isvalid = InfoClassDao.insertClass(m);
		if (isvalid) {
			request.setAttribute("messageInfoAddClass", "Thêm lớp mới thành công.");
		} else {
			request.setAttribute("messageErrorAddClass", "Tên lớp bị trùng");
		}
		String tenKhoi = request.getParameter("tenKhoi");
		List<TraCuuKhoi> DSK = InfoClassDao.selectKhoi(tenKhoi);
		request.setAttribute("DSTCK", DSK);
		request.setAttribute("nameKhoi", tenKhoi);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class.jsp");
		dispatcher.forward(request, response);

	}

	private void updateClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String nameClassOld = request.getParameter("nameOld");
		String nameClass = request.getParameter("name");
		int numberOfStudent = Integer.parseInt(request.getParameter("number"));
		Lop lop = new Lop(null, nameClass, numberOfStudent, null, null);
		boolean isvalid = InfoClassDao.updateClass(lop, nameClassOld);

		if (isvalid) {
			request.setAttribute("messageInfoUpdateClass", "Sửa thông tin lớp thành công.");
		} else {
			request.setAttribute("messageErrorUpdateClass",
					"Sửa thông tin lớp không thành công. Tên lớp muốn thay đổi đã tồn tại.");
		}
		String tenKhoi = request.getParameter("tenKhoi");
		List<TraCuuKhoi> DSK = InfoClassDao.selectKhoi(tenKhoi);
		request.setAttribute("DSTCK", DSK);
		request.setAttribute("nameKhoi", tenKhoi);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String nameClass = request.getParameter("nameRemove");
		boolean isvalid = InfoClassDao.deleteClass(nameClass);

		if (isvalid) {
			request.setAttribute("messageInfoClassDelete", "Xoá lớp không có học sinh thành công.");
		} else {
			request.setAttribute("messageErrorClassDelete", "Không thể xóa lớp đang học.");
		}
		String tenKhoi = request.getParameter("tenKhoi");
		List<TraCuuKhoi> DSK = InfoClassDao.selectKhoi(tenKhoi);
		request.setAttribute("DSTCK", DSK);
		request.setAttribute("nameKhoi", tenKhoi);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class.jsp");
		dispatcher.forward(request, response);
	}
}
