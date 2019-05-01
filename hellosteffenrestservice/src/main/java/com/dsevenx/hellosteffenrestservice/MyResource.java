package com.dsevenx.hellosteffenrestservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it! (Now in GIT) by dsevenx";
    }
    
    @Path("/sum")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSumme(@QueryParam("n1") String pSummand1,@QueryParam("n2") String pSummand2) {
        return Integer.parseInt(pSummand1)+ Integer.parseInt(pSummand2)+ "";
    }
}