package com.flight.persistence.hsqldb;

import com.flight.persistence.Flight;
import com.flight.persistence.IHsqldbFlights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightPersistenceHSQLDB implements IHsqldbFlights {

    private final String dbPath;
    public FlightPersistenceHSQLDB(final String dbPath) {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public Flight search(String departureCityCode, String arrivalCityCode) {
        Flight x = null;
        String db = "jdbc:hsqldb:hsql://localhost/flights;ifexists=true";
        String user = "SA";
        String password = "";

        try (final Connection conn = DriverManager.getConnection(db, user, password);) {
            final Statement st = conn.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM FLIGHTS WHERE DEPART = '" +departureCityCode +"' AND ARRIVE = '" + arrivalCityCode + "'");

            if(rs.next()) {
                //System.out.println("departure: " + rs.getString("DEPART") + " arrive:" + rs.getString("ARRIVE") + " distance: " + rs.getString("DISTANCE"));
                x = new Flight(rs.getString("DEPART"),rs.getString("ARRIVE"),Integer.parseInt(rs.getString("DISTANCE")));
            }

            rs.close();
            st.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return x;
    }
}
