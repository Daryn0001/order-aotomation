package kz.sdu.stu.dsalimov.configs;

public interface DbConfig {

    String dbName();

    String host();

    int port();

    String username();

    String password();

    default String url() {
        return "jdbc:postgresql://dpg-cg8aikd269vf27fnk9s0-a.oregon-postgres.render.com" +  ":" + port() + "/" + dbName();
//        return "jdbc:postgresql://" + host() + ":" + port() + "/" + dbName();
    }
}
