package kozmikoda.utilitytoolbox.passwordcase;

import javafx.util.Pair;

import java.util.Set;

public class Test {

    public static void main(String[] args) {

        try {
            PSQLConnection db = new PSQLConnection();

            MainUserAccount m = new MainUserAccount(db, "behiyy");

            m.removeService("google");

        }catch (Exception e) {
            e.printStackTrace();
        }




    }

    public static void printServices(MainUserAccount m) {
        ServiceMap s = m.getServices();

        Set<String> ss = s.services.keySet();

        for (var a : ss) {

            Pair<String, String> creds = s.services.get(a);

            System.out.println(a + creds.getKey() + " " + creds.getValue());
        }

    }

    public static void printUser(MainUserAccount m) {
        System.out.printf("%s %s %s %s \n", m.getUserName(), m.getRealName(), m.getEMail(), m.getPhoneNumber()) ;
    }

}
