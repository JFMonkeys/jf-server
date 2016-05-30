package com.github.jfmonkeys.services.runtime.endpoints;

import io.vertx.ext.web.Router;

import javax.inject.Inject;

/**
 * Created by monkey on 31/05/16.
 */
public class ReachabilityEndpoint {
    @Inject
    public ReachabilityEndpoint(Router router){
        router.route("/reach/*").handler(ctx -> {
           ctx.response().end("elllo222!!!");
        });
    }
}
