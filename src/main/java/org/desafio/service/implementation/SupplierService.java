package org.desafio.service.implementation;

import org.desafio.Exceptions;
import org.desafio.dto.SupplierCreationDTO;
import org.desafio.dto.SupplierDTO;
import org.desafio.repository.DbContract.DbContract;
import org.desafio.repository.implementation.SupplierRepository;
import org.desafio.service.ServiceContract.ServiceContract;
import org.desafio.util.SupplierServiceUtilContract.SupplierServiceUtilContract;
import org.desafio.util.implementation.SupplierServiceUtil;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@Service
public class SupplierService implements ServiceContract {

    @Inject
    private DbContract repositoryImpl = new SupplierRepository();
    @Inject
    private SupplierServiceUtilContract supplierServUtils = new SupplierServiceUtil();

    public void addSupplier(SupplierCreationDTO supplier) throws Exceptions.SupplierAlreadyExists, Exceptions.SupplierEmailIsntValid, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exceptions.SupplierCnpjIsntValid {

        SupplierDTO supplierThatWillBeSaved = new SupplierDTO(supplier);
        int id = supplierServUtils.createId();
        supplierThatWillBeSaved.setId(id);

        SupplierDTO suppByCnpj = repositoryImpl.findByCnpj(supplier.getCnpj());

        boolean isCnpjValid = supplierServUtils.CnpjValidator(supplier.getCnpj());
        if (!isCnpjValid)
            throw new Exceptions.SupplierCnpjIsntValid();

        if (suppByCnpj != null)
            throw new Exceptions.SupplierAlreadyExists();

        boolean isEmailValid = supplierServUtils.EmailValidator(supplier.getEmail());
        if (!isEmailValid)
            throw new Exceptions.SupplierEmailIsntValid();

        repositoryImpl.save(supplierThatWillBeSaved);
    }

    public List<SupplierDTO> findAllSuppliers() {
        return repositoryImpl.findAll();
    }

    public SupplierDTO findSupplier(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return repositoryImpl.findById(id);
    }

    public void updateSupplier(SupplierDTO supplier) throws Exceptions.SupplierNotFound, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        SupplierDTO supp = repositoryImpl.findById(supplier.getId());
        if (supp == null)
            throw new Exceptions.SupplierNotFound();

        repositoryImpl.update(supplier);
    }

    public void deleteSupplier(int id) throws Exceptions.SupplierNotFound, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        SupplierDTO supp = repositoryImpl.findById(id);
        if (supp == null)
            throw new Exceptions.SupplierNotFound();

        repositoryImpl.delete(id);
    }
}