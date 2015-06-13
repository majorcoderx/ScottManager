package SQLOracle;

import java.io.Serializable;
import java.sql.SQLException;

import Models.Users;

public class UserDetailDB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql;
	
	public Users getUserInfor(int empno){
		Users user = new Users();
		sql = "select ename,job,mgr,hiredate,deptno "
				+ "from emp where empno = " + empno;
		try{
			ConnToDB.rs = ConnToDB.st.executeQuery(sql);
			while (ConnToDB.rs.next()) {
				user.setEmpno(empno);
				user.setEname(ConnToDB.rs.getString(1));
				user.setJob(ConnToDB.rs.getString(2));
				user.setMgr(ConnToDB.rs.getInt(3));
				user.setHiredate(ConnToDB.rs.getDate(4));
				user.setDeptno(ConnToDB.rs.getInt(5));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return user;
	}
}
