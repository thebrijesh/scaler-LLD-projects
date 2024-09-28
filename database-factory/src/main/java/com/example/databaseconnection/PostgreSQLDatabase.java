package com.example.databaseconnection;

public class PostgreSQLDatabase extends Database {
    private String databaseName;

    public PostgreSQLDatabase(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void databaseConnection() {
        //Implement the logic to connect Postgre Database
        System.out.println("Connecting to Postgre Database");
    }

    @Override
    public DatabaseType supportsType() {
        return DatabaseType.POSTGRE_SQL;
    }
}
