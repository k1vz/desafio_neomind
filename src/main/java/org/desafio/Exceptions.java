package org.desafio;

public class Exceptions {
    public static class SupplierAlreadyExists extends Exception {
        public SupplierAlreadyExists() {
            super("SupplierDTO already exists!");
        }
    }

    public static class SupplierNotFound extends Exception {
        public SupplierNotFound() {
            super("SupplierDTO not found!");
        }
    }

    public static class SupplierEmailIsntValid extends Exception {
        public SupplierEmailIsntValid() {
            super("SupplierDTO email isn't valid!");
        }
    }


}
