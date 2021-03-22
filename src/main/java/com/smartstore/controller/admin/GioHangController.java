package com.smartstore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartstore.constant.SystemConstant;
import com.smartstore.model.GiohangModel;
import com.smartstore.model.PhoneModel;
import com.smartstore.service.iGioHangService;
import com.smartstore.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-giohanglist" })
public class GioHangController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private iGioHangService giohangService;
	
	private static final long serialVersionUID = -7299647711853066955L;
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = req.getParameter("type");
		GiohangModel model = new GiohangModel();
		String view = "";
		String id = req.getParameter("id");
		if (type != null && type.equals(SystemConstant.LIST)) {
			String pagestr = req.getParameter("page");
			String maxpageitemstr = req.getParameter("maxPageItem");
			if (pagestr != null) {
				model.setPage(Integer.parseInt(pagestr));
			}
			if (maxpageitemstr != null) {
				model.setMaxPageItem(Integer.parseInt(maxpageitemstr));
			}
			Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
			model.setListResult(giohangService.findAll2(offset, model.getMaxPageItem()));
			model.setTotalItem(giohangService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, model);
			view = "/views/admin/giohang/list.jsp";
		} else if (type != null && type.equals(SystemConstant.EDIT)) {
			if (id != null) {
				model = giohangService.findOne(Long.parseLong(id));
			}
			
			view = "/views/admin/giohang/edit.jsp";
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
