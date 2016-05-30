package com.github.jfmonkeys.services.common;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import javax.inject.Inject;

/**
 * Created by monkey on 30/05/16.
 */
public class ServiceVehicle extends AbstractVerticle {
    private final int port;

    public ServiceVehicle(int port){
        this.port = port;
    }

    @Inject
    Router router;

    @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept).listen(port);
    }

    public int getPort() {
        return port;
    }
}
