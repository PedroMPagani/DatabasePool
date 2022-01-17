package me.paganidev.sqlapi;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePool {

    private final HikariConfig hikariConfig = new HikariConfig();
    private final HikariDataSource dataSource;

    public DatabasePool(String host, int port, String password, String database, String user, int poolSize, int minIdle){
        String jdbc = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true";

        hikariConfig.setJdbcUrl(jdbc);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        hikariConfig.setMinimumIdle(minIdle);
        hikariConfig.setMaximumPoolSize(poolSize);

        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("useServerPrepStmts", true);
        hikariConfig.addDataSourceProperty("useLocalSessionState", true);
        hikariConfig.addDataSourceProperty("useLocalTransactionState", true);
        hikariConfig.addDataSourceProperty("rewriteBatchedStatements", true);
        hikariConfig.addDataSourceProperty("cacheResultSetMetadata", true);
        hikariConfig.addDataSourceProperty("cacheServerConfiguration",true);
        hikariConfig.addDataSourceProperty("elideSetAutoCommits",true);
        hikariConfig.addDataSourceProperty("maintainTimeStats",false);

        dataSource = new HikariDataSource(hikariConfig);
    }

    public DatabasePool(String host, int port, String password, String database, String user, int poolSize){
        String jdbc = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true";

        hikariConfig.setJdbcUrl(jdbc);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        hikariConfig.setMaximumPoolSize(poolSize);

        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("useServerPrepStmts", true);
        hikariConfig.addDataSourceProperty("useLocalSessionState", true);
        hikariConfig.addDataSourceProperty("useLocalTransactionState", true);
        hikariConfig.addDataSourceProperty("rewriteBatchedStatements", true);
        hikariConfig.addDataSourceProperty("cacheResultSetMetadata", true);
        hikariConfig.addDataSourceProperty("cacheServerConfiguration",true);
        hikariConfig.addDataSourceProperty("elideSetAutoCommits",true);
        hikariConfig.addDataSourceProperty("maintainTimeStats",false);

        dataSource = new HikariDataSource(hikariConfig);
    }

    public DatabasePool(String host, int port, String password, String database, String user){
        String jdbc = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true";

        hikariConfig.setJdbcUrl(jdbc);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        hikariConfig.setMaximumPoolSize(8);

        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("useServerPrepStmts", true);
        hikariConfig.addDataSourceProperty("useLocalSessionState", true);
        hikariConfig.addDataSourceProperty("useLocalTransactionState", true);
        hikariConfig.addDataSourceProperty("rewriteBatchedStatements", true);
        hikariConfig.addDataSourceProperty("cacheResultSetMetadata", true);
        hikariConfig.addDataSourceProperty("cacheServerConfiguration",true);
        hikariConfig.addDataSourceProperty("elideSetAutoCommits",true);
        hikariConfig.addDataSourceProperty("maintainTimeStats",false);

        dataSource = new HikariDataSource(hikariConfig);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}