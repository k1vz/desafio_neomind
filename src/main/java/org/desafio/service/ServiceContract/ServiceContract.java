package org.desafio.service.ServiceContract;

import org.desafio.Exceptions;
import org.desafio.dto.SupplierCreationDTO;
import org.desafio.dto.SupplierDTO;
import org.glassfish.jersey.spi.Contract;

import java.sql.SQLException;
import java.util.List;

@Contract
public interface ServiceContract {

    void addSupplier(SupplierCreationDTO supplier) throws Exceptions.SupplierAlreadyExists, Exceptions.SupplierEmailIsntValid, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    List<SupplierDTO> findAllSuppliers();

    SupplierDTO findSupplier(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void updateSupplier(SupplierDTO supplier) throws Exceptions.SupplierNotFound, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void deleteSupplier(int id) throws Exceptions.SupplierNotFound, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

}
