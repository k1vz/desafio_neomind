package org.desafio.repository;

import org.desafio.dto.SupplierDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    Connection con = null;
    private Object name;
    private Object email;
    private Object comment;
    private Object cnpj;

    public DbConnection() throws SQLException, InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/desafio";
        String user = "root";
        String password = "12345678";

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url, user, password);
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

    public void saveSupplier(SupplierDTO supplier) throws SQLException {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("insert supplier (id, name, email, comment, cnpj) values(?,?,?,?,?)");

            preparedStatement.setInt(1, supplier.getId());
            preparedStatement.setString(2, supplier.getName());
            preparedStatement.setString(3, supplier.getEmail());
            preparedStatement.setString(4, supplier.getComment());
            preparedStatement.setString(5, supplier.getCnpj());

            preparedStatement.execute();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public List<SupplierDTO> getSuppliers() throws SQLException {
        SupplierDTO supplier = null;
        List<SupplierDTO> suppliers = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from supplier");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                supplier = new SupplierDTO();
                supplier.setId(rs.getInt(1));
                supplier.setName(rs.getString(2));
                supplier.setEmail(rs.getString(3));
                supplier.setComment(rs.getString(4));
                supplier.setCnpj(rs.getString(5));
                suppliers.add(supplier);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return suppliers;
    }

    public SupplierDTO getSupplierById(int id) throws SQLException {
        SupplierDTO supplier = null;

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from supplier where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                supplier = new SupplierDTO();
                supplier.setId(rs.getInt(1));
                supplier.setName(rs.getString(2));
                supplier.setEmail(rs.getString(3));
                supplier.setComment(rs.getString(4));
                supplier.setCnpj(rs.getString(5));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

        return supplier;
    }

    public SupplierDTO getSupplierByCnpj(String cnpj) throws SQLException {
        SupplierDTO supplier = null;

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from supplier where cnpj = ?");
            preparedStatement.setString(1, cnpj);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                supplier = new SupplierDTO();
                supplier.setId(rs.getInt(1));
                supplier.setName(rs.getString(2));
                supplier.setEmail(rs.getString(3));
                supplier.setComment(rs.getString(4));
                supplier.setCnpj(rs.getString(5));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

        return supplier;
    }

    public void updateSupplier(SupplierDTO supplier) throws SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("update supplier set name = ?, email = ?, comment = ?, cnpj = ? where id = ?");

            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getEmail());
            preparedStatement.setString(3, supplier.getComment());
            preparedStatement.setString(4, supplier.getCnpj());
            preparedStatement.setInt(5, supplier.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void deleteUser(int id) throws SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("delete from supplier where id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
}
