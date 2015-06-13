package SQLOracle;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Models.Users;

public class EmpDB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql;
	
	public List<Users> getListUserFromDept(int deptno){
		List<Users> luser = new LinkedList<Users>();
		sql = "select empno, ename from emp where deptno  = "+deptno;
		try{
			ConnToDB.rs = ConnToDB.st.executeQuery(sql);
			while(ConnToDB.rs.next()){
				Users user = new Users();
				user.setEmpno(ConnToDB.rs.getInt(1));
				user.setEname(ConnToDB.rs.getString(2));
				luser.add(user);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return luser;
	}
}
