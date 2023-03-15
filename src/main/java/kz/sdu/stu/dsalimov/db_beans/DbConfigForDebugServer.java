package kz.sdu.stu.dsalimov.db_beans;

import kz.sdu.stu.dsalimov.configs.DbConfig;
import org.springframework.stereotype.Component;

@Component
public class DbConfigForDebugServer implements DbConfig {

    @Override
    public String dbName() {
        return "order_automation";
    }

    @Override
    public String host() {
        return "dpg-cg8aikd269vf27fnk9s0-a";
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
        return "t0RWbAvXlxrJZA8jRN6jJ5zQUUEI3Edy";
    }
}
