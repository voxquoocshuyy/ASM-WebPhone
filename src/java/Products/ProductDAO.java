/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import CartProducts.OrderDTO;
import huy.DB.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quoc Huy
 */
public class ProductDAO {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDAO() {

    }

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<ProductDTO> getListProduct(String search) throws SQLException {
        List<ProductDTO> list = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, name , price , quantity , categoryID\n"
                        + " FROM tblProducts\n"
                        + " WHERE name like ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, "%" + search + "%");
                list = new ArrayList<>();
                rs = pst.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    ProductDTO dto = new ProductDTO(productID, name, price, quantity, categoryID);
                    list.add(dto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<ProductDTO> display() throws Exception {
        List<ProductDTO> list = null;
        try {
            String sql = "select productID, name, price, quantity, categoryID\n"
                    + "from tblProducts\n";
                    
            conn = DBUtils.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString(1);
                String name = rs.getString(2);
                
                int price = rs.getInt(3);
                int quantity = rs.getInt(4);
                String categoryID = rs.getString(5);
                list.add(new ProductDTO(productID, name, price, quantity, categoryID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    public List<ProductDTO> getListProductCart(String search) throws SQLException {
        List<ProductDTO> list = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, name , price , quantity \n"
                        + " FROM tblProducts\n"
                        + " WHERE name like ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, "%" + search + "%");
                list = new ArrayList<>();
                rs = pst.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("productID");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");

                    ProductDTO dto = new ProductDTO(id, name, price, quantity, "");
                    list.add(dto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }



    public boolean deleteProduct(String productID) throws SQLException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE From tblProducts "
                        + " WHERE productID = ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, productID);
                check = pst.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    

    public boolean updateProduct(ProductDTO product) throws SQLException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblProducts "
                        + " SET name=? , price=?, quantity=?,"
                        + " categoryID=? "
                        + " WHERE productID=? ";
                pst = conn.prepareStatement(sql);
                pst.setString(1, product.getName());
                pst.setInt(2, product.getPrice());
                pst.setInt(3, product.getQuantity());
                pst.setString(4, product.getCategoryID());
                pst.setString(5, product.getProductID());
                check = pst.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
//    public static void main(String[] args) throws Exception{
//        ProductDAO dao = new ProductDAO();
//        System.out.println(dao.updateProduct(new ProductDTO("P-01", "Iphone 79", 5000000, 2, "CA01")));
//    }
    
    public ProductDTO findByPrimaryKey(String productID) throws ClassNotFoundException, SQLException{
        ProductDTO dto = null;
        try {
            String sql = "select name,price,quantity,categoryID from tblProducts where productID = ? ";
            conn = DBUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, productID);
            rs = pst.executeQuery();
            if(rs.next()){
                String name = rs.getString(1);
                int price = Integer.parseInt(rs.getString(2));
                int quantity = Integer.parseInt(rs.getString(3));
                String categoryID = rs.getString(4);
                dto = new ProductDTO(productID, name, price, quantity, categoryID);
            }
        } finally{
            closeConnection();
        } return dto;
    }
    
        public ProductDTO findByPrimaryKeyCart(String productID) throws ClassNotFoundException, SQLException{
        ProductDTO dto = null;
        try {
            String sql = "select name,price,quantity from tblProducts where productID = ? ";
            conn = DBUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, productID);
            rs = pst.executeQuery();
            if(rs.next()){
                String name = rs.getString(1);
                int price = Integer.parseInt(rs.getString(2));
                int quantity = Integer.parseInt(rs.getString(3));
                dto = new ProductDTO(productID, name, price, quantity, "");
            }
        } finally{
            closeConnection();
        } return dto;
    }
        public OrderDTO findOrder(String productID) throws Exception {
        OrderDTO dto = null;
        try {
            String sql = "select productID, name, price, categoryID\n" +
                        "from tblProducts \n" +
                        
                        "where productID = ?";
            conn = DBUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, productID);
            rs = pst.executeQuery();
            if(rs.next()) {
                String name = rs.getString(2);
                int price = rs.getInt(3);
                String categoryID = rs.getString(4);

                dto = new OrderDTO(productID, name, price, 0, categoryID);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    

    public boolean checkDuplicate(String productID) throws SQLException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT productID FROM tblProducts WHERE productID = ? ";
                pst = conn.prepareStatement(sql);
                pst.setString(1, productID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(ProductDTO product) throws Exception{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblProducts(productID, name, price , quantity, categoryID) VALUES(?,?,?,?,?) ";
                pst = conn.prepareStatement(sql);
                pst.setString(1, product.getProductID());
                pst.setString(2, product.getName());
                pst.setInt(3, product.getPrice());
                pst.setInt(4, product.getQuantity());
                pst.setString(5, product.getCategoryID());
                pst.executeUpdate();
                return true;
            }
        
        } finally {
            closeConnection();
        }
        return false;
    }
}
