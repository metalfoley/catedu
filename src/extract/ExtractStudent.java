package extract;

import java.sql.ResultSet;
import java.sql.SQLException;

import base.Filo;

public class ExtractStudent {
	
	public static int getRecordId(ResultSet rs){
		int id = 0;
		try {
			while(rs.next()){
				id = rs.getInt("ID");
			}
		} catch (SQLException e) {
			Filo.log("getRecordId" + e.getMessage());
		}
		return id;
	}
}
