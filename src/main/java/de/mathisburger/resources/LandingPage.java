package de.mathisburger.resources;

import de.mathisburger.factory.DataFactory;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Landing page template
 */
@Path("/landing")
public class LandingPage {

    @Inject
    Template landingPage;

    @Inject
    DataFactory factory;

    /**
     * Renders the landing page template
     * @return TemplateInstance
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return this.landingPage.data("functions", this.factory.getFunctionData().toArray());
    }
}
