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
import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;
import com.smartstore.service.iRoleService;
import com.smartstore.service.iUserService;
import com.smartstore.utils.FormUtil;
import com.smartstore.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-userlist" })
public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1448682093369612638L;

	@Inject
	private iUserService userService;
	@Inject
	private iRoleService roleService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=req.getParameter("type");
		UserModel model= new UserModel();
		String view="";
		
		String id=req.getParameter("id");

		if (type!=null&&type.equals(SystemConstant.LIST)) {
			String pagestr = req.getParameter("page");
			String maxpageitemstr = req.getParameter("maxPageItem");
			if (pagestr != null) {
				model.setPage(Integer.parseInt(pagestr));
			}
			if (maxpageitemstr != null) {
				model.setMaxPageItem(Integer.parseInt(maxpageitemstr));
			}
			Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
			model.setListResult(userService.findAll(offset, model.getMaxPageItem()));
			model.setTotalItem(userService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, model);
			view="/views/admin/user/list.jsp";
		}else if(type!=null&type.equals(SystemConstant.EDIT)) {
			if(id!=null) {
				model=userService.findOne(Long.parseLong(id));
				
			}
			
			req.setAttribute("roles", roleService.findAll());
			view="/views/admin/user/edit.jsp";
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}
}
