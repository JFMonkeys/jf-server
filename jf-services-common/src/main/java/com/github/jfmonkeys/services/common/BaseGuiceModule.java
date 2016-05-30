package com.github.jfmonkeys.services.common;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by monkey on 31/05/16.
 */
public class BaseGuiceModule extends AbstractModule {
    private final ServiceModule module;

    public BaseGuiceModule(ServiceModule module){
        this.module = module;
    }

    @Override
    protected void configure() {

        ServiceVehicle serviceVehicle = new ServiceVehicle(8080);
        bind(ServiceVehicle.class).toInstance(serviceVehicle);
        Vertx vertx = Vertx.vertx();
        bind(Router.class).toInstance(Router.router(vertx));
        bind(Vertx.class).toInstance(vertx);

        Map<Class, Class>  interfaceMapping = new HashMap<>();
        Set<Class> concrete = new HashSet<>();
        module.addSingletonBeans(interfaceMapping, concrete);

        for (Class clazz : interfaceMapping.keySet()){
            bind(clazz).to(interfaceMapping.get(clazz)).asEagerSingleton();
        }

        for (Class clazz : concrete){
            bind(clazz).asEagerSingleton();
        }

        interfaceMapping.clear();
        concrete.clear();

        module.addPrototypeBeans(interfaceMapping, concrete);

        for (Class clazz : interfaceMapping.keySet()){
            bind(clazz).to(interfaceMapping.get(clazz));
        }

        for (Class clazz : concrete){
            bind(clazz);
        }

        for (String arg : module.getArgumentsNames()){
            bind(String.class).annotatedWith(Names.named(arg)).toInstance(findValue(arg));
        }

    }

    private String findValue(String arg) {
        String val = System.getProperty(arg);
        if (val != null){
            return val;
        }
        val = System.getenv(arg);
        return val;
    }

}
