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

import Dao.changePasswordDao;
import Dao.changeRuleDao;
import Dao.signInDao;
import Model.HocSinh;
import Model.Mon;
import Model.signIn;

@WebServlet("/changePasswordServlet")
public class changePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private changePasswordDao ChangePasswordDao;
    
	@Resource(name="jdbc/student_management")
	private DataSource datasource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		ChangePasswordDao = new changePasswordDao(datasource);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {
		case "/addAccount":
			try {
				addAccount(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			} 
			break;
		case "/updatePass":
            try {
            	updatePassword(request, response);
            } catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
            break;
		case "/updateRole":
            try {
            	updateRole(request, response);
            } catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
            break;
            
		case "/deleteAccount":
            try {
            	deleteAccount(request, response);
            } catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
            break;
        default:
        	try {
            	renderAccountRoleAdmin(request, response);
            } catch (ClassNotFoundException | ServletException | IOException e) {
                e.printStackTrace();
            }
            break;
		}
	}
	
	private void addAccount(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String name = request.getParameter("newUsername");
		String pass = request.getParameter("newPassword");
		String role = request.getParameter("roleUser");
		
		signIn s = new signIn(0, name, pass, Integer.parseInt(role));
		boolean isvalid = ChangePasswordDao.addAccount(s);
		if (isvalid) {
	        request.setAttribute("messageInfoAddAccount", "Thêm tài khoản mới thành công.");
	    } else {
	        request.setAttribute("messageErrorAddAccount", "Tên tài khoản bị trùng");
	    }
		List<signIn> DSTK = ChangePasswordDao.renderAccountRoleAdmin();
		request.setAttribute("DSTK", DSTK);
		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}
	
	private void renderAccountRoleAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		List<signIn> DSTK = ChangePasswordDao.renderAccountRoleAdmin();
		request.setAttribute("DSTK", DSTK);
		request.setAttribute("messageerror", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/account.jsp");
		dispatcher.forward(request, response);
	}
	
	
	public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
	public int countWords(String input) {
        if (input == null) {
            return -1;
        }
        int count = 0;
        int size = input.length();
        boolean notCounted = true;
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB 
                    && input.charAt(i) != BREAK_LINE) {
                if(notCounted) {
                    count++;
                    notCounted = false;
                }
            } else {
                notCounted = true;
            }
        }
        return count;
    }
	
	private void updatePassword(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String username = request.getParameter("usernameUpdate");
        String newPass = request.getParameter("newPass");
        String cNewPass = request.getParameter("cNewPass");
        boolean isvalid = ChangePasswordDao.updatePassword(newPass, username);
        if (isvalid) {
        	request.setAttribute("messageinfo", "Thay đổi mật khẩu thành công.");
        }
        else {
        	if (newPass == "" || newPass.length()<5) {
            	request.setAttribute("messageerror", "Mật khẩu có độ dài phải lớn hơn 5, có kí tự đặc biệt, số và chữ");
            } else if (newPass.length()!=cNewPass.length()) {
            	request.setAttribute("messageerror", "Xác nhận mật khẩu không đúng.");
            }
        }
        List<signIn> DSTK = ChangePasswordDao.renderAccountRoleAdmin();
		request.setAttribute("DSTK", DSTK);
		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}
	
	private void updateRole(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String username = request.getParameter("userNameRole");
        String newRole = request.getParameter("roleAccount");
        if(Integer.parseInt(newRole) == 1) {
        	request.setAttribute("messageerror", "Không thể thay đổi người dùng thành admin.");
        }
        else {
        	boolean isvalid = ChangePasswordDao.updateRole(Integer.parseInt(newRole), username);
        	if (isvalid && Integer.parseInt(newRole) != 1) {
            	request.setAttribute("messageinfo", "Thiết lập phân quyền thành công");
            }
            else {
                request.setAttribute("messageerror", "Không thể thay đổi người dùng thành admin.");
            }
        }
        List<signIn> DSTK = ChangePasswordDao.renderAccountRoleAdmin();
		request.setAttribute("DSTK", DSTK);
		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}
	
	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String userNameRoleDelete = request.getParameter("userNameRoleDelete");
		boolean isvalid = ChangePasswordDao.deleteAccount(userNameRoleDelete);
        if(isvalid) {
        	request.setAttribute("messageinfo", "Xoá tài khoản thành công.");
        }
        else {
        	request.setAttribute("messageerror", "Xoá tài khoản không thành công.");
        }
        List<signIn> DSTK = ChangePasswordDao.renderAccountRoleAdmin();
		request.setAttribute("DSTK", DSTK);
		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
