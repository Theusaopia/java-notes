package application;

import db.DB;
import exceptions.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConnection();

            ps = conn.prepareStatement(
              "INSERT INTO seller " +
                      "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                      "VALUES " +
                      "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, "Matheus O Mito");
            ps.setString(2, "matheus@email.com");
            ps.setDate(3, new Date(sdf.parse("17/11/1998").getTime()));
            ps.setDouble(4, 74940.87);
            ps.setInt(5, 4);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0 ) {
                ResultSet rs = ps.getGeneratedKeys();

                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! id: " + id);
                }
            }
            else {
                System.out.println("No rows affected.");
            }
        }
        catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
