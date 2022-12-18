package kozmikoda.utilitytoolbox.passwordcase;

public class Test {

    public static void main(String[] args) {

        try {
            PSQLConnection db = new PSQLConnection();

            MainUserAccount m = new MainUserAccount(db, "behiyy");



        }catch (Exception e) {
            e.printStackTrace();
        }




    }

}
