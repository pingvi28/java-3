import java.sql.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    private static Connection connection;
    protected static Statement statement;
    private static final String url = "jdbc:postgresql://localhost:5432/genome";
    private static final String user = "postgres";
    private static final String password = "1234567890";
    static String genome1, genome2;
    static ArrayList<String> dividedGen1, dividedGen2;

    public static void main(String[] args) throws SQLException {
        readFile();
        connect();

        int[] division = new int[]{2,5,9}; // на сколько надо делить
        for (int i = 0; i < division.length; i++) {
            int s = division[i];

            dividedGen1 = new ArrayList<>();
            dividedGen2 = new ArrayList<>();
            //деление генома
            for (int j = 0; j < genome1.length() - s + 1; j++) {
                String str = genome1.substring(j, j + s);
                dividedGen1.add(str);
            }
            for (int j = 0; j < genome2.length() - s + 1; j++) {
                String str = genome2.substring(j, j + s);
                dividedGen2.add(str);
            }

            statement.execute("CREATE TABLE genome_1_" + s + "(part_of_the_genome VARCHAR);");
            statement.execute("CREATE TABLE genome_2_" + s + "(part_of_the_genome VARCHAR);");
            for (int j = 0; j < dividedGen1.size(); j++) {
                statement.execute("INSERT INTO genome_1_" + s + " VALUES ('" + dividedGen1.get(j) + "');");
            }
            for (int j = 0; j < dividedGen2.size(); j++) {
                statement.execute("INSERT INTO genome_2_" + s + " VALUES ('" + dividedGen2.get(j) + "');");
            }

            ResultSet rs = statement.executeQuery(
                    "WITH _numerator AS(" +
                            "    SELECT part_of_the_genome FROM genome_1_" + s + " INTERSECT SELECT part_of_the_genome from genome_2_" + s + ")," +
                            " _denominator AS(" +
                            "    SELECT part_of_the_genome FROM genome_1_" + s + " UNION SELECT part_of_the_genome from genome_2_" + s + ")" +
                            "SELECT (SELECT count(*)::float8 FROM _numerator) / (SELECT count(*)::float8 from _denominator);"
            );

            rs.next();
            System.out.println(rs.getString(1));
            statement.execute("INSERT INTO genome_results (division, result) VALUES (" + s + ", " + rs.getString(1) + ");");
        }
    }

    protected static void readFile(){
        try {
            genome1 = new String(Files.readAllBytes(Paths.get("src/main/res/Genome_1.txt")), StandardCharsets.US_ASCII);

        } catch (IOException e) {
            System.out.print("Can't read 'Genome_1' file");
        }

        try {
            genome2 = new String(Files.readAllBytes(Paths.get("src/main/res/Genome_2.txt")), StandardCharsets.US_ASCII);
            genome2.replaceAll("/n","");

        } catch (IOException e) {
            System.out.print("Can't read 'Genome_2' file");
        }
    }

    public static void connect() {
        try {
            //Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            createResTable();
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }

    private static void createResTable() throws SQLException {
        statement.execute("CREATE TABLE genome_results(division int, result float);");
    }
}