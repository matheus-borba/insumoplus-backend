package br.edu.engsoft.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.edu.engsoft.dto.OrganizationResponseDTO;
import br.edu.engsoft.dto.ProductResponseDTO;
import br.edu.engsoft.dto.UserResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;

@ApplicationScoped
@RegisterRestClient(configKey = "pipedrive-api")
public interface PipedriveClient {

    public static final String AUTH = "x-api-token";

    @GET
    @Path("/v2/organizations")
    OrganizationResponseDTO getAllOrganizations(@HeaderParam(AUTH) String auth);

    @GET
    @Path("/v2/products")
    ProductResponseDTO getAllProducts(@HeaderParam(AUTH) String auth);

    @GET
    @Path("/v1/users")
    UserResponseDTO getAllUsers(@HeaderParam(AUTH) String auth);
}
