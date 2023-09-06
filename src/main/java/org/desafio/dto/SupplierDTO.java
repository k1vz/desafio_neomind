package org.desafio.dto;

public class SupplierDTO {

    private int id;
    private String name;
    private String email;
    private String comment;
    private String cnpj;

    public SupplierDTO() {
    }

    public SupplierDTO(SupplierCreationDTO supCreationDTO) {
        this.name = supCreationDTO.getName();
        this.email = supCreationDTO.getEmail();
        this.comment = supCreationDTO.getComment();
        this.cnpj = supCreationDTO.getCnpj();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
