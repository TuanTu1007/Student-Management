package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Dao.InfoStudentsDao;
import Dao.infoClassDao;
import Model.HocSinh;
import Model.Lop;
import Model.Mon;
import Model.TraCuuHocSinh;

@WebServlet("/InfoStudentsServlet")
public class InfoStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InfoStudentsDao infoStudentsDao;
	private infoClassDao InfoClassDao;
	@Resource(name="jdbc/student_management")
	private DataSource datasource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		infoStudentsDao = new InfoStudentsDao(datasource);
		InfoClassDao = new infoClassDao(datasource);
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
				insertStudent(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			} 
			break;
		case "/searchByName":
			try {
				selectStudentByName(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateInfoStudent(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
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
		List<HocSinh> DSHS = infoStudentsDao.selectAllStudent();
		request.setAttribute("DSHS", DSHS);
		request.setAttribute("messageerror", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/infoStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	private void selectStudentByName(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String name = request.getParameter("search-student-name");
		String nameClass = request.getParameter("search-student-class");
		List<TraCuuHocSinh> DSTCHS = infoStudentsDao.selectStudent(name, nameClass);
		List<Lop> DSL = InfoClassDao.selectAllClass();
		request.setAttribute("DSTCHS", DSTCHS);
		request.setAttribute("searchStudentName", name);
		
		request.setAttribute("DSL", DSL);
		request.setAttribute("searchStudentClass", nameClass);
		if (DSTCHS.isEmpty()) {
		    request.setAttribute("messageerror", "Không tìm thấy học sinh.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/searchStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String[] tenHSArray = request.getParameterValues("tenHS");
        String[] gioiTinhArray = request.getParameterValues("gender-group");
        String[] namSinhArray = request.getParameterValues("namSinh");
        String[] diaChiArray = request.getParameterValues("diaChi");
        String[] emailArray = request.getParameterValues("email");

        List<HocSinh> students = new ArrayList<>();
        for (int i = 0; i < tenHSArray.length; i++) {
            HocSinh hs = new HocSinh();
            hs.setTenHS(tenHSArray[i]);
            hs.setGioiTinh(gioiTinhArray[i]);
            hs.setNamSinh(namSinhArray[i]);
            hs.setDiaChi(diaChiArray[i]);
            hs.setEmail(emailArray[i]);
            students.add(hs);
        }

        if (infoStudentsDao.checkEmailList(students) && infoStudentsDao.checkAgeList(students)) {
        	infoStudentsDao.insertListStudents(students);
			request.setAttribute("messageInfo", "Thêm học sinh thành công.");
        } else if (!infoStudentsDao.checkAgeList(students)) {
        	request.setAttribute("messageErrorAge", "Thêm học sinh không thành công. Tuổi không hợp lệ.");
        } else if (!infoStudentsDao.checkEmailList(students)) {
        	request.setAttribute("messageErrorEmailExist", "Thêm học sinh không thành công. Email đã tồn tại.");
        }
        List<HocSinh> DSHS = infoStudentsDao.selectAllStudent();
		request.setAttribute("DSHS", DSHS);
		request.setAttribute("messageerror", "");
		request.getRequestDispatcher("/infoStudent.jsp").forward(request, response);
	}
	
//	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException, ClassNotFoundException, SQLException {
//		String name = request.getParameter("studentName");
//		String gender = request.getParameter("gender-group");
//		String year = request.getParameter("studentYear");
//		String address = request.getParameter("studentAddress");
//		String email = request.getParameter("studentEmail");
//		
//		HocSinh hs = new HocSinh(null, name, gender, year, address, email);
//		
//		boolean isvalid = infoStudentsDao.checkAge(hs);
//		boolean isvalidEmail = infoStudentsDao.checkEmail(hs);
//		if (isvalid && isvalidEmail) {
//			if (name.equals("")) {
//				request.setAttribute("messagEerrorName", "Thêm học sinh không thành công. Chưa nhập tên học sinh.");
//			} else if (gender == null) {
//				request.setAttribute("messageErrorGender", "Thêm học sinh không thành công. Chưa nhập giới tính.");
//			} else if (address.equals("")) {
//				request.setAttribute("messageErrorAddress", "Thêm học sinh không thành công. Chưa nhập địa chỉ.");
//			} else if (email.equals("")) {
//				request.setAttribute("messageErrorEmail", "Thêm học sinh không thành công. Chưa nhập email.");
//			} else {
//				infoStudentsDao.insertStudent(hs);
//				request.setAttribute("messageInfo", "Thêm học sinh thành công.");
//			}
//		} else if (!isvalid){
//			request.setAttribute("messageErrorAge", "Thêm học sinh không thành công. Tuổi không hợp lệ.");
//		} else if (!isvalidEmail) {
//			request.setAttribute("messageErrorEmailExist", "Thêm học sinh không thành công. Email đã tồn tại.");
//		}
//		List<HocSinh> DSHS = infoStudentsDao.selectAllStudent();
//		request.setAttribute("DSHS", DSHS);
//		request.setAttribute("messageerror", "");
//		request.getRequestDispatcher("/infoStudent.jsp").forward(request, response);
//	}
	
	private void updateInfoStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String nameStudent = request.getParameter("studentName");
		String nameGender = request.getParameter("gender-group-new");
		String nameYear = request.getParameter("studentYearNew");
		String nameAddress = request.getParameter("studentAddressNew");
		String nameEmail = request.getParameter("studentEmailNew");

		
		HocSinh hs = new HocSinh(null, nameStudent, nameGender, nameYear, nameAddress, nameEmail);
		
		boolean isvalidAge = infoStudentsDao.checkAge(hs);
		boolean isvalidEmail = infoStudentsDao.checkEmail(hs);
	    if (isvalidAge && isvalidEmail) {
	        request.setAttribute("messageInfoUpdateStudent", "Sửa thông tin thành công.");
	        infoStudentsDao.updateInfoStudent(hs,nameStudent, nameAddress, nameEmail, nameYear);
	    } else {
	        request.setAttribute("messageErrorUpdateStudent", "Sửa thông tin không thành công.");
	    }
	    List<HocSinh> DSHS = infoStudentsDao.selectAllStudent();
		request.setAttribute("DSHS", DSHS);
	    request.getRequestDispatcher("/infoStudent.jsp").forward(request, response);
	}
}
