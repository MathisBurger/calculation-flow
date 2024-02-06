package de.mathisburger.resources;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The start page
 */
@Path("/start")
public class Start {

    @Inject
    Template start;

    /**
     * Sends the rendered start page template
     * @return TemplateInstance
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return this.start.instance();
    }
}
