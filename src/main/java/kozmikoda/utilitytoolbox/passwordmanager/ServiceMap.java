package kozmikoda.utilitytoolbox.passwordmanager;

import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ServiceMap {

    // key of the HashMap ==> Service Name
    // 1.st value in the pair ==> User Identifier
    // 2.nd value in the pair ==> Password
    HashMap<String, Pair<String, String>> services = new HashMap<>();

    ServiceMap() {}

    ServiceMap(PSQLConnection dbConnection, String userDatabase) throws SQLException {

        dbConnection.connectToDatabase(userDatabase);
        Statement s = dbConnection.getCommandExecutor();

        ResultSet rs = s.executeQuery("SELECT * FROM services ;");

        while(rs.next()) {
            services.put(
                    rs.getString(
                            PSQLConnection.getServiceNameColumn()),
                    new Pair<>(rs.getString(PSQLConnection.getUserIdentifierColumn()),
                            rs.getString(PSQLConnection.getPasswordColumn()) ) );
        }


    }

}
