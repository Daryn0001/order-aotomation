package kz.sdu.stu.dsalimov.db_beans;

import kz.sdu.stu.dsalimov.configs.DbConfig;
import org.springframework.stereotype.Component;

@Component
public class DbConfigForDebugServer implements DbConfig {

    @Override
    public String dbName() {
        return "railway";
    }

    @Override
    public String host() {
        return "containers-us-west-170.railway.app";
    }

    @Override
    public int port() {
        return 7088;
    }

    @Override
    public String username() {
        return "postgres";
    }

    @Override
    public String password() {
        return "TEXLLKNXkb5adkLku66j";
    }
}
