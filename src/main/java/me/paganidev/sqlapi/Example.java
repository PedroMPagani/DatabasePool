package me.paganidev.sqlapi;

import java.sql.Connection;

public class Example {

    public void example(){
        // this is how you use it.
        DatabasePool databasePool = new DatabasePool("host",3306,"","","",8);
        try (Connection connection = databasePool.getConnection()){
            // connection is AutoClosable, it needs to be released otherwise there will be issues.
        } catch (Exception ignored){
        }
    }

}