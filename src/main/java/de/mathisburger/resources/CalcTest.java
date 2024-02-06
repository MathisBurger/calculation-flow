package de.mathisburger.resources;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Tests an function
 */
@Path("/test")
public class CalcTest {

    @Inject
    Template test;

    @Inject
    EndpointConfig config;

    /**
     * Provides test template
     *
     * @param id The function ID
     * @return TemplateInstance
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("id") String id) {
        Function func = this.config.functions().get(id);
        return this.test
                .data("parameters", func.parameters())
                .data("id", id);
    }
}
