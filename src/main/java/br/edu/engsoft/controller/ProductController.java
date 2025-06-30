package br.edu.engsoft.controller;
import br.edu.engsoft.model.Product;
import br.edu.engsoft.repository.ProductRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductRepository productRepository;

    @GET
    public Response getAll() {
        List<Product> products = productRepository.getAll();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return productRepository.findById(id)
                .map(product -> Response.ok(product).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/search")
    public Response getByName(@QueryParam("name") String name) {
        if (name == null || name.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Query param 'name' is required.").build();
        }
        List<Product> products = productRepository.findByName(name);
        return Response.ok(products).build();
    }

    @GET
    @Path("/owner/{ownerId}")
    public Response getByOwnerId(@PathParam("ownerId") Long ownerId) {
        List<Product> products = productRepository.listByOwnerId(ownerId);
        return Response.ok(products).build();
    }
}