package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("UserRegistration.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		if (op.equals("SignUp")) {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String loginId = req.getParameter("loginId");
			String password = req.getParameter("password");
			String dob = req.getParameter("dob");
			String address = req.getParameter("address");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			UserBean bean = new UserBean();
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(loginId);
			bean.setPassword(password);
			try {
				bean.setDob(sdf.parse(dob));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			bean.setAddress(address);
			
			UserModel model = new UserModel();
			try {
				model.add(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			req.setAttribute("msg","User register Successfully......!!!");
			
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
			
			rd.forward(req, resp);

	}
		if (op.equals("Reset")) {
			
			resp.sendRedirect("UserRegistration.jsp");
			
			
			
		}

}}