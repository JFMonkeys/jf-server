package com.github.jfmonkeys.services.runtime;


import com.github.jfmonkeys.services.common.ServiceModule;
import com.github.jfmonkeys.services.common.ServiceModuleBootstrap;
import com.github.jfmonkeys.services.runtime.endpoints.ReachabilityEndpoint;

import java.util.Map;
import java.util.Set;

/**
 * This is similar to a spring context
 * it contains a list of all the beans used in the module
 * It is possible to map interfaces to implementations or just to mention the concrete class
 */
public class RuntimeModule implements ServiceModule {
    @Override
    public void addSingletonBeans(Map<Class, Class> interfaceMapping, Set<Class> concrete) {
        concrete.add(ReachabilityEndpoint.class);
    }

    @Override
    public void addPrototypeBeans(Map<Class, Class> interfaceMapping, Set<Class> concrete) {

    }

    @Override
    public String[] getArgumentsNames() {
        return new String[0];
    }

    public static void main(String[] args){
        ServiceModuleBootstrap.run(new RuntimeModule());
    }
}
