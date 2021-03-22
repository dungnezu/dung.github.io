package com.smartstore.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartstore.model.PhoneModel;
import com.smartstore.service.iPhoneService;
import com.smartstore.utils.HttpUtil;
import com.smartstore.utils.UploadFIleUtil;

@WebServlet(urlPatterns = { "/api-admin-phone" })
public class PhoneApi extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7582406177869481818L;
	@Inject
	private iPhoneService phoneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PhoneModel PhoneModel = HttpUtil.of(req.getReader()).toModel(PhoneModel.class);
		PhoneModel.setDt_anh1(UploadFIleUtil.fileURL);
		PhoneModel = phoneService.insert(PhoneModel);
		mapper.writeValue(resp.getOutputStream(), PhoneModel);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PhoneModel updatePhone = HttpUtil.of(req.getReader()).toModel(PhoneModel.class);
		updatePhone=phoneService.update(updatePhone);
		mapper.writeValue(resp.getOutputStream(), updatePhone);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		PhoneModel PhoneModel = HttpUtil.of(request.getReader()).toModel(PhoneModel.class);
		phoneService.delete(PhoneModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
