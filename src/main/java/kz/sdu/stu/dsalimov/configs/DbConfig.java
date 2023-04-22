package kz.sdu.stu.dsalimov.configs;

public interface DbConfig {

    String dbName();

    String host();

    int port();

    String username();

    String password();

    default String url() {
        return "jdbc:postgresql://dpg-ch1tbq5gk4qarqmdvs1g-a.frankfurt-postgres.render.com" +  ":" + port() + "/" + dbName();
//        return "jdbc:postgresql://" + host() + ":" + port() + "/" + dbName();
    }
}
