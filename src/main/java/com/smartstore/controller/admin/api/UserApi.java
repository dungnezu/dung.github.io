package com.smartstore.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartstore.model.UserModel;
import com.smartstore.service.iUserService;
import com.smartstore.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-user" })
public class UserApi extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2641972013876735714L;
	@Inject
	private iUserService userService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel usermodel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		usermodel = userService.insert2(usermodel);
		mapper.writeValue(resp.getOutputStream(), usermodel);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel updateUser = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		updateUser = userService.update(updateUser);
		mapper.writeValue(resp.getOutputStream(), updateUser);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		userService.delete(userModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
