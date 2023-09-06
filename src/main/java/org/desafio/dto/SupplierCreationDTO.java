package org.desafio.dto;

public class SupplierCreationDTO {

    private String name;
    private String email;
    private String comment;
    private String cnpj;

    public SupplierCreationDTO() {
    }

    public SupplierCreationDTO(String name, String email, String comment, String cnpj) {
        this.name = name;
        this.email = email;
        this.comment = comment;
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}