package com.github.jfmonkeys.services.common;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * Created by monkey on 31/05/16.
 */
public class ServiceModuleBootstrap {
    public static void run(ServiceModule module){
        run(module, result -> {});
    }

    public static DeploymentContext run(ServiceModule module, Handler<AsyncResult<String>> assertSuccessHandler){
        BaseGuiceModule baseGuiceModule = new BaseGuiceModule(module);
        Injector injector = Guice.createInjector(baseGuiceModule);
        Vertx vertx = injector.getInstance(Vertx.class);
        ServiceVehicle vehicle = injector.getInstance(ServiceVehicle.class);
        vertx.deployVerticle(vehicle, assertSuccessHandler);
        DeploymentContext ctx = new DeploymentContext();
        ctx.setVertx(vertx);
        ctx.setPort(vehicle.getPort());
        return ctx;
    }
}
