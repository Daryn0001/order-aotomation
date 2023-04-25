package kz.sdu.stu.dsalimov.db_beans;

import kz.sdu.stu.dsalimov.configs.DbConfig;
import org.springframework.stereotype.Component;

@Component
public class DbConfigForDebugServer implements DbConfig {

    @Override
    public String dbName() {
        return "order_automation_el6c";
    }

    @Override
    public String host() {
        return "dpg-ch1tbq5gk4qarqmdvs1g-a";
    }

    @Override
    public int port() {
        return 5432;
    }

    @Override
    public String username() {
        return "root";
    }

    @Override
    public String password() {
        return "xzapKmzbpvZdcCGEQduYv5rC5mfpMWBm";
    }
}
