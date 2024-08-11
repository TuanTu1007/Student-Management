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

import Dao.changeRuleDao;
import Dao.infoSubjectDao;
import Model.ChangeRule;
import Model.Mon;
import Model.TraCuuKhoi;

@WebServlet("/ChangeRuleServlet")
public class ChangeRuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private changeRuleDao ChangeRuleDao;
    
    @Resource(name="jdbc/student_management")
	private DataSource datasource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		ChangeRuleDao = new changeRuleDao(datasource);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}
		switch (action) {
		case "/insert":
            try {
            	insertChangeRule(request, response);
            } catch (ClassNotFoundException | ServletException | IOException e) {
                e.printStackTrace();
            }
            break;
		case "/updateTuoi":
            try {
            	updateTuoi(request, response);
            } catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
            break;
            
		case "/updateSiSo":
            try {
            	updateSiSo(request, response);
            } catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
            break;
            
		case "/updateDiemDat":
            try {
            	updateDiemDat(request, response);
            } catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
            break;
		case "/updateDiem":
            try {
            	updateDiem(request, response);
            } catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
            break;
		default:
			try {
				renderThamSo(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void renderThamSo(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, ClassNotFoundException, SQLException {
		ChangeRule cr = ChangeRuleDao.renderThamSo();
		request.setAttribute("CR", cr);
	    request.getRequestDispatcher("/changeRule.jsp").forward(request, response);
	}
	
	private void insertChangeRule(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException {
		String name = request.getParameter("ruleName");
		String value = request.getParameter("ruleStandard");

		boolean isvalid = ChangeRuleDao.insertChangeRule(name, Integer.parseInt(value));
		if (isvalid) {
	        request.setAttribute("messageInfoAddSubject", "Thêm quy định mới thành công.");
	    } else {
	        request.setAttribute("messageErrorAddSubject", "Tên quy định bị trùng");
	    }
		ChangeRule cr = ChangeRuleDao.renderThamSo();
		request.setAttribute("CR", cr);
	    request.getRequestDispatcher("/changeRule.jsp").forward(request, response);
	}
		
	private void updateTuoi(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		int tuoiToiDa = Integer.parseInt(request.getParameter("tuoiHSToiDa"));
        int tuoiToiThieu = Integer.parseInt(request.getParameter("tuoiHSToiThieu"));
        boolean isvalid = ChangeRuleDao.updateTuoiToiThieuToiDa(tuoiToiThieu, tuoiToiDa);
        
		if (isvalid) {
			request.setAttribute("messageInfoUpdateAge", "Thay đổi giới hạn tuổi thành công.");
		} else {
			request.setAttribute("messageErrorUpdateAge",
					"Thay đổi thất bại.");
		}
		ChangeRule cr = ChangeRuleDao.renderThamSo();
		request.setAttribute("CR", cr);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/changeRule.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateSiSo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		int siSoToiDa = Integer.parseInt(request.getParameter("siSoToiDa"));
		boolean isvalid = ChangeRuleDao.updateSiSoToiDa(siSoToiDa);
		if (isvalid) {
			request.setAttribute("messageInfoUpdateSiSo", "Thay đổi giới hạn sĩ số thành công.");
		} else {
			request.setAttribute("messageErrorUpdateSiSo",
					"Thay đổi thất bại.");
		}
		ChangeRule cr = ChangeRuleDao.renderThamSo();
		request.setAttribute("CR", cr);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/changeRule.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateDiemDat(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		int diemDat = Integer.parseInt(request.getParameter("pointPass"));
		boolean isvalid = ChangeRuleDao.updateDiemDat(diemDat);
		if (isvalid) {
			request.setAttribute("messageInfoUpdateDiemDat", "Thay đổi giới hạn điểm đạt thành công.");
		} else {
			request.setAttribute("messageErrorUpdateDiemDat",
					"Thay đổi thất bại.");
		}
		ChangeRule cr = ChangeRuleDao.renderThamSo();
		request.setAttribute("CR", cr);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/changeRule.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateDiem(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		int diemToiDa = Integer.parseInt(request.getParameter("maxPoint"));
        int diemToiThieu = Integer.parseInt(request.getParameter("minPoint"));
        boolean isvalid = ChangeRuleDao.updateDiem(diemToiThieu, diemToiDa);
        if (isvalid) {
			request.setAttribute("messageInfoUpdateDiem", "Thay đổi giới hạn điểm tối thiểu, tối đa thành công.");
		} else {
			request.setAttribute("messageErrorUpdateDiem",
					"Thay đổi thất bại.");
		}
        ChangeRule cr = ChangeRuleDao.renderThamSo();
		request.setAttribute("CR", cr);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/changeRule.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
