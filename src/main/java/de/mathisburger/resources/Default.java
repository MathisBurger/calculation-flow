package de.mathisburger.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

/**
 * Default controller
 */
@Path("/")
public class Default {

    /**
     * Redirects to start page
     * @return Response
     */
    @GET
    public Response get() {
        return Response
                .seeOther(UriBuilder.fromUri("/start").build())
                .build();
    }
}
