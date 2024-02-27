package oop;

interface DBConnection {
    void connect();
}

class OracleConnection implements DBConnection {
    @Override
    public void connect() {
        System.out.println("Oracle connected");
    }
}

class MySQLConnection implements DBConnection {
    @Override
    public void connect() {
        System.out.println("MySQL connected");
    }
}

class PostgreSQLConnection implements DBConnection {
    @Override
    public void connect() {
        System.out.println("PostgreSQL connected");
    }
}

class DbConnectionFactory {
    private final DBConnection dbConnection;

    public DbConnectionFactory(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
        this.dbConnection.connect();
    }

    public DBConnection getConnection() {
        return this.dbConnection;
    }
}

public class DependencyInversion {
    public static void main(String[] args) {
        DBConnection conn = new OracleConnection();
        DbConnectionFactory factory = new DbConnectionFactory(conn);
    }
}
