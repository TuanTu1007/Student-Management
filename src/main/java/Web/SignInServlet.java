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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Dao.InfoStudentsDao;
import Dao.infoClassDao;
import Dao.signInDao;
import Dao.tablePointDao;
import Model.HocSinh;
import Model.Lop;
import Model.QuaTrinh;
import Model.signIn;
import Model.tablePointSubjectClass;

@WebServlet("/SignIn")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private signInDao SignInDao;  
    private InfoStudentsDao infoStudentsDao;
    private infoClassDao InfoClassDao;
    private tablePointDao TablePointDao;
    @Resource(name="jdbc/student_management")
	private DataSource datasource;

    @Override
    public void init() {
    	SignInDao = new signInDao(datasource);
    	infoStudentsDao = new InfoStudentsDao(datasource);
    	InfoClassDao = new infoClassDao(datasource);
    	TablePointDao = new tablePointDao(datasource);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		signIn acc;
		HocSinh hs;
		Lop l;
		tablePointSubjectClass p;
		QuaTrinh pAVG;
		try {
			acc = SignInDao.Login(username, password);
			hs = infoStudentsDao.selectOneStudent(username);
			l = InfoClassDao.selectOneClass(username);
			List<tablePointSubjectClass> listPointStudent = TablePointDao.selectPointOneStudent(username);
			pAVG = TablePointDao.selectAVGStudent(username);
			if (acc==null) {
				request.setAttribute("messageerror", "Sai tài khoản hoặc mật khẩu");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/signIn.jsp");
				dispatcher.forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("account", acc);
				session.setAttribute("hs", hs);
				session.setAttribute("l", l);
				session.setAttribute("pAVG", pAVG);
				session.setAttribute("p", listPointStudent);
				request.getRequestDispatcher("account.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
