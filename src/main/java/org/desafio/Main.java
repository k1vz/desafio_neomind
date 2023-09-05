package org.desafio;

import org.desafio.dto.SupplierDTO;

import java.util.List;

public class Main {

    public void main(String[] args) throws Exceptions.SupplierAlreadyExists, Exceptions.SupplierEmailIsntValid {


//        DbContract supRepo = new SupplierRepository();
//        implementation supServUtils = new implementation(supRepo);
//        SupplierService supServ = new SupplierService(supRepo, supServUtils);
//
//        supServ.addSupplier(new SupplierDTO(4343, "Bata", "anasdata@gmail.com", "comment", "34534/3243-00"));
//        supServ.addSupplier(new SupplierDTO(42342, "Tomate", "sada@gmail.com", "comment", "34644/3243-00"));
//        supServ.addSupplier(new SupplierDTO(5352, "Fejão", "anta@gmail.com", "adfdf", "34521e24/3243-00"));
//
//        printListOfSuppliers(supServ.findAllSuppliers());
    }

    public static void printListOfSuppliers(List<SupplierDTO> supplier) {
        for (SupplierDTO supplierDTO : supplier) {
            System.out.println("------------");
            System.out.println("name: " + supplierDTO.getName());
            System.out.println("email: " + supplierDTO.getEmail());
            System.out.println("comment: " + supplierDTO.getComment());
            System.out.println("cnpj: " + supplierDTO.getCnpj());
        }
    }
}

/*
CREATE TABLE supplier (
    id INTEGER PRIMARY KEY,
    name VARCHAR,
    email VARCHAR,
    comment VARCHAR,
    cnpj VARCHAR UNIQUE
);
 */
