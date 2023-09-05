package org.desafio;

import org.desafio.presentation.SupplierBinder;
import org.desafio.repository.DbContract.DbContract;
import org.desafio.repository.implementation.SupplierRepository;
import org.desafio.service.ServiceContract.ServiceContract;
import org.desafio.service.implementation.SupplierService;
import org.desafio.util.SupplierServiceUtilContract.SupplierServiceUtilContract;
import org.desafio.util.implementation.SupplierServiceUtil;
import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
    public App() {

        packages("org.desafio");
        register(new SupplierBinder() {
            @Override
            protected void configure() {
                bind(SupplierService.class).to(ServiceContract.class);
                bind(SupplierRepository.class).to(DbContract.class);
                bind(SupplierService.class).to(SupplierServiceUtil.class);
                bind(SupplierServiceUtil.class).to(SupplierServiceUtilContract.class);
            }
        });
    }
}
