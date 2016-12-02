import java.sql.*;

public class DataBaseControl {
    private static DataBaseControl dataBaseControl;
    private String DB_CONNECTION;
    private String DB_USER;
    private String DB_PASSWORD;
    private Connection conn;

    static {
        dataBaseControl = new DataBaseControl();
    }

    private DataBaseControl() {
        DB_CONNECTION = "jdbc:mysql://localhost:3306/database1";
        DB_USER = "root";
        DB_PASSWORD = "1604";
        dbInit();
    }

    public static DataBaseControl getInstance() {
        return dataBaseControl;
    }

    private void dbInit() {
        try{
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Apartments (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "rooms TINYINT, area SMALLINT, district VARCHAR(16) NOT NULL , " +
                    "address VARCHAR(20) NOT NULL, price MEDIUMINT)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DATABASE IS WORKING WRONG.");
        }
    }

    public void printAll() {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *FROM Apartments");
            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            String[] temp = new String[] {
                    resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2),
                    resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4),
                    resultSetMetaData.getColumnName(5), resultSetMetaData.getColumnName(6),
            };
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            System.out.printf("|%4s|%7s|%6s|%16s|%20s|%10s|\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
            System.out.println("+----+-------+------+----------------+--------------------+----------+");

            while (resultSet.next()) {
                System.out.printf("|%4d|%7d|%6d|%16s|%20s|%10d|\n", resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
            }
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void printWithArea(int lowest, int highest) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *FROM Apartments WHERE area >= ? AND area <= ?");
            preparedStatement.setInt(1, lowest);
            preparedStatement.setInt(2, highest);

            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            String[] temp = new String[] {
                    resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2),
                    resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4),
                    resultSetMetaData.getColumnName(5), resultSetMetaData.getColumnName(6),
            };
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            System.out.printf("|%4s|%7s|%6s|%16s|%20s|%10s|\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
            System.out.println("+----+-------+------+----------------+--------------------+----------+");

            while (resultSet.next()) {
                System.out.printf("|%4d|%7d|%6d|%16s|%20s|%10d|\n", resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
            }
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printWithinPrice(int lowest, int highest) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *FROM Apartments WHERE price >= ? AND price <= ?");
            preparedStatement.setInt(1, lowest);
            preparedStatement.setInt(2, highest);

            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            String[] temp = new String[] {
                    resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2),
                    resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4),
                    resultSetMetaData.getColumnName(5), resultSetMetaData.getColumnName(6),
            };
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            System.out.printf("|%4s|%7s|%6s|%16s|%20s|%10s|\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
            System.out.println("+----+-------+------+----------------+--------------------+----------+");

            while (resultSet.next()) {
                System.out.printf("|%4d|%7d|%6d|%16s|%20s|%10d|\n", resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
            }
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printWithRooms(int rooms) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *FROM Apartments WHERE rooms = ?");
            preparedStatement.setInt(1, rooms);

            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            String[] temp = new String[] {
                    resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2),
                    resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4),
                    resultSetMetaData.getColumnName(5), resultSetMetaData.getColumnName(6),
            };
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            System.out.printf("|%4s|%7s|%6s|%16s|%20s|%10s|\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
            System.out.println("+----+-------+------+----------------+--------------------+----------+");

            while (resultSet.next()) {
                System.out.printf("|%4d|%7d|%6d|%16s|%20s|%10d|\n", resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
            }
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printInDistrict(String district) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *FROM Apartments WHERE district = ?");
            preparedStatement.setString(1, district);

            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            String[] temp = new String[] {
                    resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2),
                    resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4),
                    resultSetMetaData.getColumnName(5), resultSetMetaData.getColumnName(6),
            };
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            System.out.printf("|%4s|%7s|%6s|%16s|%20s|%10s|\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
            System.out.println("+----+-------+------+----------------+--------------------+----------+");

            while (resultSet.next()) {
                System.out.printf("|%4d|%7d|%6d|%16s|%20s|%10d|\n", resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
            }
            System.out.println("+----+-------+------+----------------+--------------------+----------+");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToBase(int rooms, int area, String district, String address, int price) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Apartments " +
                    "(rooms, area, district, address, price) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, rooms);
            preparedStatement.setInt(2, area);
            preparedStatement.setString(3, district);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, price);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
