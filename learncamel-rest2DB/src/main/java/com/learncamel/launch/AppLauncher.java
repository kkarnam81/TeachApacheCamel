package com.learncamel.launch;

import com.learncamel.routes.rest2DB.Rest2DBRoute;
import org.apache.camel.main.Main;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by z001qgd on 7/11/17.
 */
public class AppLauncher {


    public static void main(String[] args) throws Exception {
        Main main = new Main();

        String url = "jdbc:postgresql://localhost:5432/localDB";

        main.bind("myDataSource",setupDataSource(url));  //map based registry
        //main.bind();

        main.addRouteBuilder(new Rest2DBRoute());

        System.out.println("Starting Camel JMS to DB Route.");

        main.run();


    }


    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("postgres");
        ds.setUrl(connectURI);
        return ds;
    }
}
