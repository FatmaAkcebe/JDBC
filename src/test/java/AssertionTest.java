import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.AssertJUnit.*;

public class AssertionTest extends DatabaseHelper {
    @Test
    void testQueryResultsValid() throws SQLException {
        // Çalıştırılacak geçerli  sorgu numarası
        int queryRun = 41;

        String query = SampleJDBC.QueryResults(queryRun);
        assertNotNull( "Sorgu geçerli olmalı.",query);

        DBConnectionOpen();
        ResultSet rs = statement.executeQuery(query);
        assertNotNull("Sorgu sonucu geçerli olmalı.", rs);
        DBConnectionClose();

    }

        @Test
        void testQueryResultsInvalid() {
            // Geçersiz sorgu numarası
            int queryRun = -1;

            String query = SampleJDBC.QueryResults(queryRun);
            assertNull("Geçersiz sorgu numarası null olmalı.", query);
        }
}