package kz.sdu.stu.dsalimov.configs;

public interface DbConfig {

    String dbName();

    String host();

    int port();

    String username();

    String password();

    default String url() {
        return "jdbc:postgresql://TEXLLKNXkb5adkLku66j@containers-us-west-170.railway.app" +  ":" + port() + "/" + dbName();
//        return "jdbc:postgresql://" + host() + ":" + port() + "/" + dbName();
    }
}
