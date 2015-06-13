package Controller;

import SQLOracle.LoginDB;
import Service.*;
import ActionObject.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Login implements Serializable, ManagerCompany  {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private String password = "";

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*--------------- process in here-------------*/
	
	@Override
	public String getAction() {
		// TODO Auto-generated method stub
		SQLOracle.LoginDB lgdb = new LoginDB();
	lgdb.getUser(id, password);
		if(StaticValue.isLogged){
			if(StaticValue.userLog.getJob().equals(Job.President)){
				return "/Views/Personalized/prehome.xhtml?faces-redirect=true";
			}
			else if(StaticValue.userLog.getJob().equals(Job.Manager)){
				return "/Views/Personalized/manhome.xhtml?faces-redirect=true";
			}
			else return "/Views/Personalized/otherhome.xhtml?faces-redirect=true";
		}
		else{
			if(id ==0  && ! password.equals("")){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Loggin fail", "Try again, thank !"));
			}
			return "";
		}
	}
	@Override
	public String getAction(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
