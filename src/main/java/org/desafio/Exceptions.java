package org.desafio;

public class Exceptions {

    public static class SupplierAlreadyExists extends Exception {
        ErrorEntity errorEntity;

        public SupplierAlreadyExists() {
            super("SupplierDTO already exists!");
            this.errorEntity = new ErrorEntity("SupplierDTO already exists!");
        }

        public ErrorEntity getErrorEntity() {
            return errorEntity;
        }
    }

    public static class SupplierNotFound extends Exception {
        ErrorEntity errorEntity;

        public SupplierNotFound() {
            super("SupplierDTO not found!");
            this.errorEntity = new ErrorEntity("SupplierDTO not found!");
        }

        public ErrorEntity getErrorEntity() {
            return errorEntity;
        }
    }

    public static class SupplierEmailIsntValid extends Exception {
        ErrorEntity errorEntity;

        public SupplierEmailIsntValid() {
            super("SupplierDTO email isn't valid!");
            this.errorEntity = new ErrorEntity("SupplierDTO email isn't valid!");
        }

        public ErrorEntity getErrorEntity() {
            return errorEntity;
        }
    }

    public static class SupplierCnpjIsntValid extends Exception {
        ErrorEntity errorEntity;

        public SupplierCnpjIsntValid() {
            super("SupplierDTO CNPJ isn't valid!");
            this.errorEntity = new ErrorEntity("SupplierDTO CNPJ isn't valid!");
        }

        public ErrorEntity getErrorEntity() {
            return errorEntity;
        }
    }

    public static class ErrorEntity {
        private String error;

        ErrorEntity(String error) {
            setError(error);
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}