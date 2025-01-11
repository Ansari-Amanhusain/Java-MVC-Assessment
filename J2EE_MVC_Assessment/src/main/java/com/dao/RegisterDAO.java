package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.AdminModel;
import com.util.AdminUtil;

public class RegisterDAO 
{
	Connection cn=null;
	public int getAdminData(AdminModel rmodel)
	{
		int x=0;
		this.cn=new AdminUtil().getConnectionAdmin();
		String qry="Insert into admin(firstname,lastname,username,password) Values(?,?,?,?)";
		try
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, rmodel.getFirstname());
			st.setString(2, rmodel.getLastname());
			st.setString(3, rmodel.getUsername());
			st.setString(4, rmodel.getPassword());
			
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return x;
	}

}
