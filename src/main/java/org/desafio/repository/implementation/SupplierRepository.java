package org.desafio.repository.implementation;

import org.desafio.dto.SupplierDTO;
import org.desafio.repository.DbConnection;
import org.desafio.repository.DbContract.DbContract;

import java.util.List;

public class SupplierRepository implements DbContract {

    @Override
    public void save(SupplierDTO supplier) {
        try {
            DbConnection conn = new DbConnection();

            conn.saveSupplier(supplier);

            conn.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SupplierDTO> findAll() {
        try {
            DbConnection conn = new DbConnection();
            List<SupplierDTO> suppliers = conn.getSuppliers();
            conn.closeConnection();

            return suppliers;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SupplierDTO findByCnpj(String cnpj) {
        try {
            DbConnection conn = new DbConnection();
            SupplierDTO supplier = conn.getSupplierByCnpj(cnpj);
            conn.closeConnection();

            return supplier;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SupplierDTO findById(int id) {
        try {
            DbConnection conn = new DbConnection();
            SupplierDTO supplier = conn.getSupplierById(id);
            conn.closeConnection();

            return supplier;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(SupplierDTO supplier) {
        try {
            DbConnection conn = new DbConnection();

            conn.updateSupplier(supplier);

            conn.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            DbConnection conn = new DbConnection();

            conn.deleteUser(id);

            conn.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
