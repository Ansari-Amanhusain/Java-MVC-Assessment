package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.EmployeeModel;
import com.util.EmployeeUtil;

public class ViewDAO {
    public List<EmployeeModel> getDisplay() {
        List<EmployeeModel> employeeList = new ArrayList<EmployeeModel>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            cn = new EmployeeUtil().getEmployeeData();
            String qry = "SELECT * FROM employee";
            st = cn.prepareStatement(qry);
            rs = st.executeQuery();
            while (rs.next()) {
                EmployeeModel model = new EmployeeModel();
                model.setEmployeeid(rs.getInt("employeeid"));
                model.setFirstname(rs.getString("firstname"));
                model.setLastname(rs.getString("lastname"));
                model.setEmail(rs.getString("email"));
                model.setMobile(rs.getString("mobile"));
                model.setAddress(rs.getString("address"));
                model.setGender(rs.getString("gender"));
                model.setPassword(rs.getString("password"));
                employeeList.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }
    public boolean updateEmployee(EmployeeModel emp) {
        boolean isUpdated = false;
        try (Connection cn = new EmployeeUtil().getEmployeeData();
             PreparedStatement st = cn.prepareStatement("UPDATE employee SET firstname = ?, lastname = ?, email = ?, mobile = ?, address = ?, gender = ?, password = ? WHERE employeeid = ?")) {
            st.setString(1, emp.getFirstname());
            st.setString(2, emp.getLastname());
            st.setString(3, emp.getEmail());
            st.setString(4, emp.getMobile());
            st.setString(5, emp.getAddress());
            st.setString(6, emp.getGender());
            st.setString(7, emp.getPassword());
            st.setInt(8, emp.getEmployeeid());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }


	public EmployeeModel getEmployeeById(int employeeid) 
	{
		EmployeeModel employee = null;
        try (Connection cn = new EmployeeUtil().getEmployeeData();
             PreparedStatement st = cn.prepareStatement("SELECT * FROM employee WHERE employeeid = ?")) {
            st.setInt(1, employeeid);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    employee = new EmployeeModel();
                    employee.setEmployeeid(rs.getInt("employeeid"));
                    employee.setFirstname(rs.getString("firstname"));
                    employee.setLastname(rs.getString("lastname"));
                    employee.setEmail(rs.getString("email"));
                    employee.setMobile(rs.getString("mobile"));
                    employee.setAddress(rs.getString("address"));
                    employee.setGender(rs.getString("gender"));
                    employee.setPassword(rs.getString("password"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
	}
	
	public boolean deleteEmployeeById(int employeeid) {
	    boolean isDeleted = false;
	    try (Connection cn = new EmployeeUtil().getEmployeeData();
	         PreparedStatement st = cn.prepareStatement("DELETE FROM employee WHERE employeeid = ?")) {
	        st.setInt(1, employeeid);
	        int rowsAffected = st.executeUpdate();
	        if (rowsAffected > 0) {
	            isDeleted = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isDeleted;
	}



}
