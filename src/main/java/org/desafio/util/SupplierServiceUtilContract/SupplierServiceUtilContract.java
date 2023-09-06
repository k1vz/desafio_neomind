package org.desafio.util.SupplierServiceUtilContract;

import org.glassfish.jersey.spi.Contract;

import java.sql.SQLException;

@Contract
public interface SupplierServiceUtilContract {

    int createId() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    boolean EmailValidator(String email);

    boolean CnpjValidator(String cnpj);
}