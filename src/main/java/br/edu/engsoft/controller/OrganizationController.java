package br.edu.engsoft.controller;

import br.edu.engsoft.model.Organization;
import br.edu.engsoft.repository.OrganizationRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganizationController {

    @Inject
    OrganizationRepository organizationRepository;

    @GET
    public Response getAll() {
        List<Organization> organizations = organizationRepository.getAll();
        return Response.ok(organizations).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return organizationRepository.findById(id)
                .map(organization -> Response.ok(organization).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/search")
    public Response getByName(@QueryParam("name") String name) {
        if (name == null || name.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Query param 'name' is required.").build();
        }
        List<Organization> organizations = organizationRepository.findByName(name);
        return Response.ok(organizations).build();
    }

    @GET
    @Path("/owner/{ownerId}")
    public Response getByOwnerId(@PathParam("ownerId") Long ownerId) {
        List<Organization> organizations = organizationRepository.listByOwnerId(ownerId);
        return Response.ok(organizations).build();
    }
}