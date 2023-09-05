package org.desafio.repository.DbContract;

import org.desafio.dto.SupplierDTO;
import org.glassfish.jersey.spi.Contract;

import java.sql.SQLException;
import java.util.List;

@Contract
public interface DbContract {
    void save(SupplierDTO supplier);

    List<SupplierDTO> findAll();

    SupplierDTO findByCnpj(String cnpj);

    SupplierDTO findById(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void update(SupplierDTO supplier);

    void delete(int id);

}
