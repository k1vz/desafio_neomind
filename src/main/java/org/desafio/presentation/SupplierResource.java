package org.desafio.presentation;


import org.desafio.dto.SupplierCreationDTO;
import org.desafio.dto.SupplierDTO;
import org.desafio.service.ServiceContract.ServiceContract;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/supplier")
public class SupplierResource {
    @Inject
    private ServiceContract supService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SupplierDTO> getSupplier() {
        try {
            return supService.findAllSuppliers();
        } catch (Exception err) {
            return null;
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SupplierDTO getSupplierById(@PathParam("id") int id) {
        try {
            return supService.findSupplier(id);
        } catch (Exception err) {
            return null;
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSupplier(SupplierCreationDTO supplier) {
        try {
            supService.addSupplier(supplier);
            return Response.status(Response.Status.CREATED).entity(supplier).build();
        } catch (Exception err) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err.getMessage())
                    .build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSupplier(SupplierDTO supplier) {
        try {
            supService.updateSupplier(supplier);

            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSupplier(@PathParam("id") int id) {
        try {
            supService.deleteSupplier(id);

            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage())
                    .build();
        }
    }

}