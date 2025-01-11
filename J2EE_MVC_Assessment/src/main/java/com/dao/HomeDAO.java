package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.AdminModel;
import com.util.AdminUtil;

public class HomeDAO 
{
	Connection cn=null;
	public AdminModel verifyUser(int userid)
	{
		AdminModel model=null;
		this.cn=new AdminUtil().getConnectionAdmin();
		String qry="Select * from admin where userid=?";
		
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setInt(1, userid);;
			
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				model=new AdminModel();
				model.setUserid(rs.getInt(1));
				model.setFirstname(rs.getString("firstname"));
				model.setLastname(rs.getString(3));
				model.setUsername(rs.getString("username"));
				model.setPassword(rs.getString("password"));
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}	

}
