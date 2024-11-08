import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleJDBC extends DatabaseHelper {//Veritabanına bağlanıp sorguyu çalıştıran ana sınıf
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();



        DBConnectionClose();
}}
