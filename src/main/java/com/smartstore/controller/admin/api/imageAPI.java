package com.smartstore.controller.admin.api;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartstore.model.ImageModel;
import com.smartstore.utils.HttpUtil;
import com.smartstore.utils.UploadFIleUtil;

@WebServlet(urlPatterns = {"/api-image"})
public class imageAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3493457784947262366L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ImageModel image=new ImageModel();
		image=HttpUtil.of(req.getReader()).toModel(ImageModel.class);
		byte[] decodeBase64= Base64.getDecoder().decode(image.getBase64().getBytes());
		ObjectMapper mapper= new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UploadFIleUtil.writeOrUpdate(decodeBase64, image.getName());
		mapper.writeValue(resp.getOutputStream(), image);
	}
}
 