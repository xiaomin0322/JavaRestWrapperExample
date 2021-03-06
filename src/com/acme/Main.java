package com.acme;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.net.URI;

/**
 * Main class.
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on.
    public static final String BASE_URI = "http://localhost:8080/api/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resource defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resource and providers
        // in com.com.acme package
        final ResourceConfig rc = new ResourceConfig().packages("com.acme.resource");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     */
    public static void main(String[] args) throws Exception {
        final HttpServer server = startServer();
        System.out.println(String.format("Open %sapplication.wadl for endpoint info\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }

}

