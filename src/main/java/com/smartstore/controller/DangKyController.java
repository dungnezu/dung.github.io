package com.smartstore.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartstore.model.UserModel;
import com.smartstore.service.iUserService;
import com.smartstore.utils.SessionUtil;

@WebServlet(urlPatterns = { "/dang-ky" })
public class DangKyController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8148822810867968300L;

	@Inject
	private iUserService userService;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if (action != null && action.equals("dangky")) {
			String alert = req.getParameter("alert");
			String message = req.getParameter("message");
			if (message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login/register.jsp");
			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if (action != null && action.equals("dangky")) {
			String password1 = req.getParameter("password1");
			UserModel model = new UserModel();
			model.setUser_ten(req.getParameter("username"));
			model.setUser_matkhau(req.getParameter("password"));
			model.setUser_sodienthoai(req.getParameter("sodienthoai"));
			model.setUser_mail(req.getParameter("email"));
			model.setUser_diachi(req.getParameter("diachi"));
			UserModel model1 = userService.findByUserPass(model.getUser_ten(), model.getUser_matkhau());

			if (model.getUser_matkhau().equals(password1) == false) {
				resp.sendRedirect(
						req.getContextPath() + "/dang-ky?action=dangky&message=password_incorrect&alert=danger");
			} else {
				if (model1 != null) {
					resp.sendRedirect(req.getContextPath()
							+ "/dang-ky?action=dangky&message=account_already_exists&alert=danger");

				} else {
					if (userService.insert(model) != null) {
						resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
					} else {
						resp.sendRedirect(req.getContextPath()
								+ "/dang-ky?action=dangky&message=registration_failed&alert=danger");
					}
				}
			}

		}
	}

}
