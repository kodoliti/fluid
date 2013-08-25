package org.kodoliti.fluid.core;

import org.kodoliti.fluid.bootstrap.ConfigurationLoader;

public class RuntimeEnvironment {

    public static boolean running;

    public static void setEnvironment() {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
       // createProcessEnvironment(configurationLoader.load().get().process());
    }

}