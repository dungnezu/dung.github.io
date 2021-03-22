package com.smartstore.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartstore.model.GiohangModel;
import com.smartstore.model.UserModel;
import com.smartstore.service.iGioHangService;
import com.smartstore.utils.HttpUtil;
import com.smartstore.utils.SessionUtil;

@WebServlet(urlPatterns = { "/add-tocart" })
public class GioHangAPI extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204985784575677376L;
	@Inject
	private iGioHangService giohangService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
		if (userModel == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login/login.jsp");
			rd.forward(req, resp);
		} else {
			ObjectMapper mapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			GiohangModel giohangModel = HttpUtil.of(req.getReader()).toModel(GiohangModel.class);
			giohangModel = giohangService.insert(giohangModel);
			mapper.writeValue(resp.getOutputStream(), giohangModel);
		}

	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		GiohangModel giohangModel = HttpUtil.of(req.getReader()).toModel(GiohangModel.class);
		giohangService.delete(giohangModel.getGh_id(),giohangModel.getGh_dt_id());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
