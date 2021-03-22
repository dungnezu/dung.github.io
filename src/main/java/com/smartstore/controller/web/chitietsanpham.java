package com.smartstore.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartstore.constant.SystemConstant;
import com.smartstore.model.PhoneModel;
import com.smartstore.service.iBrandService;
import com.smartstore.service.iPhoneService;

@WebServlet(urlPatterns = { "/chitiet_sp" })

public class chitietsanpham extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8063278851970985211L;

	@Inject
	private iBrandService brandService;
	@Inject
	private iPhoneService phoneService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String phoneid=req.getParameter("id");
		PhoneModel model=new  PhoneModel();
		if(phoneid!=null) {
			Long	id=Long.parseLong(phoneid);
			model=phoneService.findOne(id);
		}
		req.setAttribute("brands", brandService.findAll());
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/chitietsanpham.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
