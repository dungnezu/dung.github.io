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
import com.smartstore.model.DonHangModel;
import com.smartstore.service.iDonHangService;
import com.smartstore.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-donhanglist" })
public class DonHangController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private iDonHangService donhangService;

	private static final long serialVersionUID = -7299647711853066955L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = req.getParameter("type");
		DonHangModel model = new DonHangModel();
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
			model.setListResult(donhangService.findAll2(offset, model.getMaxPageItem()));
			model.setTotalItem(donhangService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, model);
			view = "/views/admin/donhang/list.jsp";
		} else if (type != null && type.equals(SystemConstant.EDIT)) {
			if (id != null) {
				model = donhangService.findOne(Long.parseLong(id));
			}

			view = "/views/admin/donhang/edit.jsp";
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
