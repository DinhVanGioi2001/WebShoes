/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.DBConnect;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hung Dinh load dữ liệu từ DB lên
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

//    public DAO() throws ClassNotFoundException {
//        DBConnect dh = DBConnect.getSingletonInstance();
//        conn = dh.getConn();
//    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product";
        try {
            conn = new DBConnect().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return list;
//        List<Product> list = new ArrayList<>();
//        Statement stm = null;
//        try {
//            stm = conn.createStatement();
//        } catch (SQLException ex) {
//            System.out.println("stm la null");
//        }
//
//        String query = "select * from Product";
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//        } catch (SQLException ex) {
//            System.out.println("Ko co result set");
//        }
//
//        try {
//            while (rs.next()) {
//                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
//                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
//            }
//        } catch (SQLException ex) {
//        }
//        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBConnect().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Product getLastProduct() {
        String query = "select top 1* from Product order by id desc";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> getProductByCateID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product where cateid = ?";
        try {
            conn = new DBConnect().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Product getProductById(String id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product where id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id); // thay thế dấu hỏi đầu tiên bằng id
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product where [name] like ?";
        try {
            conn = new DBConnect().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Account login(String user, String pass) {
        String query = "select * from Account where [user] = ? and pass = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from Account where [user] = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account signup(String user, String pass) {
        String query = "insert into Account values(?,?,1,1)";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteProduct(String pid) {
        String query = "delete from Product where id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getProductBySellId(int id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where sell_ID = ?";
        try {
            conn = new DBConnect().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void insertProduct(String name, String image, String price, String title,
            String description, String category, int id) {
        String query = "insert into Product values(?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void editProduct(String name, String image, String price, String title,
            String description, String category, String pid) {
        String query = "update Product set \n"
                + "[name] = ?,\n"
                + "image=?,\n"
                + "price=?,\n"
                + "title=?,\n"
                + "description=?,\n"
                + "cateId=?\n"
                + "where id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void editProductByJson(Product p) {
        String query = "update Product set \n"
                + "[name] = ?,\n"
                + "image=?,\n"
                + "price=?,\n"
                + "title=?,\n"
                + "description=?,\n"
                + "where id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setString(2, p.getImage());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getTitle());
            ps.setString(5, p.getDescription());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
            System.out.println("Sua truyen thanh cong");
        } catch (Exception e) {
            System.out.println("Không thể thực thi");
        }
    }

    public List<Product> getTop3() {
        List<Product> list = new ArrayList();
        String query = "select top 3 * from product";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getNext3Product(int amount) {
        List<Product> list = new ArrayList();
        String query = "select * from product order by  id\n"
                + "offset ? rows\n"
                + "fetch next 3 rows only";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    // đếm số lượng product trong db
    public int getTotalPage() {
        String query = "select count(*) from product";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1); // lay du lieu
                int endPage = count / 6;
                if (count % 6 != 0) {
                    endPage++;
                }
                return endPage;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> getPaging(int index) {
        String query = "select * from product order by id \n"
                + "offset ? rows fetch first 6 rows only";
        List<Product> list = new ArrayList<>();
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
