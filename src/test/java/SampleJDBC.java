
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertNotNull;


public class SampleJDBC extends DatabaseHelper {//Veritabanına bağlanıp sorguyu çalıştıran ana sınıf
    public static void main(String[] args) throws SQLException {

        DBConnectionOpen();

        // Çalıştırılacak sorgu numarasını belirlenir
        int queryRun = 41;

        // Sorguyu çalıştır ve sonuçları yazdır
        String queryToExecute = QueryResults(queryRun);
        if (queryToExecute != null) {
            System.out.println("Sorgu Sonuçları:");
            ResultSet rs = statement.executeQuery(queryToExecute);
            QueryResults(rs);
        } else {
            System.out.println("Geçersiz sorgu numarası");
        }


        DBConnectionClose();
    }

    public static String QueryResults(int queryNumber) {
        // Sorgu numarasının geçerli olup olmadığını kontrol etmek
        if (queryNumber >= 0 && queryNumber < Queries.QUERIES.length) {
            return Queries.QUERIES[queryNumber];
        }
        return null;
    }

}
