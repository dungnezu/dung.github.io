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

@WebServlet(urlPatterns = { "/trang-chu" })

public class HomeController extends HttpServlet {

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
		String hangid = req.getParameter("hangid");
		String pageStr = req.getParameter("page");
		String maxPageItemStr = req.getParameter("maxPageItem");
		PhoneModel model = new PhoneModel();
		if (pageStr == null) {
			
			model.setPage(1);
			
		} else {
			model.setPage(Integer.parseInt(pageStr));
		}
		
		if (maxPageItemStr != null) {
			model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
		}
		model.setMaxPageItem(8);
		
		Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
		
		model.setTotalItem(phoneService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		
		if (hangid != null) {
			Long id=Long.parseLong(hangid);
			model.setListResult(phoneService.findAllbyhangID(offset, model.getMaxPageItem(), id));
		} else {
			model.setListResult(phoneService.findAll(offset, model.getMaxPageItem()));
		}
		req.setAttribute(SystemConstant.MODEL, model);
		req.setAttribute("brands", brandService.findAll());
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
