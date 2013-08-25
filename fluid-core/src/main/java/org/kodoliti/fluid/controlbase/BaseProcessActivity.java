package org.kodoliti.fluid.controlbase;

import org.kodoliti.fluid.bootstrap.RuntimeContext;
import org.kodoliti.fluid.configuration.Configuration;
import org.kodoliti.fluid.core.RuntimeEnvironment;

public class BaseProcessActivity  {//implements ProcessActivity {

    public BaseProcessActivity() {
        setRuntimeEnvironment(null);
    }

    public BaseProcessActivity(Configuration cfg) {
        setRuntimeEnvironment(cfg);
    }

    private void setRuntimeEnvironment(Configuration cfg) {
        if (cfg == null && !RuntimeEnvironment.running)
            RuntimeEnvironment.setEnvironment();

        RuntimeContext rc = new RuntimeContext();
        rc.run();
    }


    public org.kodoliti.fluid.activity2.Process start(String name) {
        return null;
    }
}
