package com.hspedu.fgrmybatis2.config;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class MapperBean {
    private String interfaceName;
    private List<Function> functions;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "MapperBean{" +
                "interfaceName='" + interfaceName + '\'' +
                ", functions=" + functions +
                '}';
    }
}
