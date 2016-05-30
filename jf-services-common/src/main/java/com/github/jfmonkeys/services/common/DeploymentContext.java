package com.github.jfmonkeys.services.common;

import io.vertx.core.Vertx;

/**
 * Created by monkey on 31/05/16.
 */
public class DeploymentContext {
    private int port;
    private Vertx vertx;

    public void setPort(int port){
        this.port = port;
    }

    public void setVertx(Vertx vertx){
        this.vertx = vertx;
    }

    public int getPort(){
        return port;
    }

    public Vertx getVertx(){
        return vertx;
    }
}
