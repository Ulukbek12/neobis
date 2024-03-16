import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neo", "root", "F543689c");



            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE uluk"+
                    "(id INT PRIMARY KEY not NULL, " +
                    "name VARCHAR(20), " +
                    "last VARCHAR(20))";
            statement.executeUpdate(sql);
            PreparedStatement pstatement = connection.prepareStatement(
                    "INSERT INTO uluk VALUES(1,'toraliev','proper')"
            );
            pstatement.executeUpdate();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM uluk");

            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


    }
}