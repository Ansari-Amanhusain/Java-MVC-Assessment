package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.EmployeeModel;
import com.util.EmployeeUtil;

public class InsertDAO 
{
	Connection cn=null;
	public int employeeInsert(EmployeeModel emodel)
	{
		int x=0;
		this.cn=new EmployeeUtil().getEmployeeData();
		String qry="Insert into employee(firstname,lastname,email,mobile,address,gender,password) Values(?,?,?,?,?,?,?)";
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1,emodel.getFirstname());
			st.setString(2,emodel.getLastname());
			st.setString(3,emodel.getEmail());
			st.setString(4,emodel.getMobile());
			st.setString(5,emodel.getAddress());
			st.setString(6,emodel.getGender());
			st.setString(7,emodel.getPassword());
			
			x=st.executeUpdate();
			
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

}
