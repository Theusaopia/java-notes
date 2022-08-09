package application;


import db.DB;
import exceptions.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("" +
                    "UPDATE seller " +
                    "SET BaseSalary = BaseSalary + ? " +
                    "WHERE " +
                    "(DepartmentId = ?)"
            );

            st.setDouble(1, 200);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Affected Rows: " + rowsAffected);
        }
        catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
