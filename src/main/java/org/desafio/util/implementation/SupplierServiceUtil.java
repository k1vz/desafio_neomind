package org.desafio.util.implementation;

import org.desafio.dto.SupplierDTO;
import org.desafio.repository.DbContract.DbContract;
import org.desafio.util.SupplierServiceUtilContract.SupplierServiceUtilContract;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.Random;

public class SupplierServiceUtil implements SupplierServiceUtilContract {

    @Inject
    private DbContract repositoryImpl;

    public int createId() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Random r = new Random();
        boolean isIdNotCreated = true;
        int id;

        do {
            id = Math.abs(r.nextInt());
            SupplierDTO suppById = repositoryImpl.findById(id);

            if (suppById == null) {
                isIdNotCreated = false;
            }

        } while (isIdNotCreated);

        return id;
    }

    public boolean EmailValidator(String email) {
        return email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
    }

    public boolean CnpjValidator(String cnpj) {
        return cnpj.length() > 13 && cnpj.length() < 18;
    }
}
