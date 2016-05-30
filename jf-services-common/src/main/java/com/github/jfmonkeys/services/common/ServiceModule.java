package com.github.jfmonkeys.services.common;

import java.util.Map;
import java.util.Set;

/**
 * Created by monkey on 31/05/16.
 */
public interface ServiceModule {
    void addSingletonBeans(Map<Class, Class> interfaceMapping, Set<Class> concrete);
    void addPrototypeBeans(Map<Class, Class> interfaceMapping, Set<Class> concrete);
    String[] getArgumentsNames();
}
