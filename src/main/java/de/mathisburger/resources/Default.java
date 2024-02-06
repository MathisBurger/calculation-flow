package de.mathisburger.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

@Path("/")
public class Default {

    @GET
    public Response get() {
        return Response
                .seeOther(UriBuilder.fromUri("/start").build())
                .build();
    }
}
