/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import huy.DB.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Quoc Huy
 */
public class UserDAO {
    public UserDTO checkLogin (String userID, String password) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "SELECT name, roleID FROM tblUsers WHERE userID=? and password=? ";
                
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs= stm.executeQuery();
                if(rs.next()){
                    String name = rs.getString("name");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, password ,name,"","",roleID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        
     return user;   
    }
    
}
