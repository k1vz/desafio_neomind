package org.desafio.presentation;

import org.desafio.repository.implementation.SupplierRepository;
import org.desafio.service.ServiceContract.ServiceContract;
import org.desafio.service.implementation.SupplierService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class SupplierBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(SupplierService.class).to(ServiceContract.class);
        bind(SupplierRepository.class).to(SupplierRepository.class);
    }
}
