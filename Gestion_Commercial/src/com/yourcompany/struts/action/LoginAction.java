/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import DAO.Users;
import DAO.UsersDAO;

import com.yourcompany.struts.form.LoginForm;

/** 
 * MyEclipse Struts
 * Creation date: 02-23-2015
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="loginForm" input="/form/login.jsp" validate="true"
 */
public class LoginAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
		UsersDAO user = new UsersDAO();
		List<Users> l = user.findAll();
		
		ActionForward action = null;
		Iterator it = l.iterator();
		
		String inputLogin =  loginForm.getLogin();
		String inputPass =  loginForm.getPass();
		
		while(it.hasNext()){
			
			Users u = (Users) it.next();
			if( u.getLogin().equals( inputLogin ) && u.getPass().equals( inputPass ) ){
				
				HttpSession sess = request.getSession();
				sess.setAttribute("login", inputLogin);
				action = mapping.findForward("success");
			}
			
			else{
				action = mapping.findForward("echec");
			}
		}
		
		return action;
	}
}