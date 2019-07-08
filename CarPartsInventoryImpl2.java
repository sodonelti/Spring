package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carPartsImpl2")
public class CarPartsInventoryImpl2 implements CarPartsInventory {

	@Autowired
	@Qualifier("dataSource1")
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
				try {
					//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
					conn=dataSource.getConnection();
					
					String sql="insert into TBL_CARPARTS values(?,?,?,?)";	 							
					stmt=conn.prepareStatement(sql);
					
				     stmt.setInt(1, carPart.getPartNo());
				     stmt.setString(2, carPart.getPartName());
				     stmt.setString(3, carPart.getCarModel());
				     stmt.setInt(4, carPart.getQuantity());
					stmt.executeUpdate();
					}
				catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					try 
					{
						conn.close();
						}
					catch(Exception e) {
						
					}
				}
}


	public List<CarPart> getAvailableParts() {
		//select Query code from jdbc
		return null;
	}
	

}
