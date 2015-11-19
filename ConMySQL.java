import java.sql.*;
import java.util.ArrayList;

/**
 * Created by simon on 15/11/19.
 */
public class ConMySQL{
    static ArrayList<TrackClass> track = new ArrayList<>();

    public static void main(String[] args){
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        //String url = "jdbc:mysql://localhost:3306/MyData";
        String url = "jdbc:mysql://192.168.1.115/qiming";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "mysql";
        try {
            // 加载驱动程序
            Class.forName(driver);

            // 连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);

            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            // statement用来执行SQL语句
            Statement statement = conn.createStatement();

            // 要执行的SQL语句
            String sql = "select * from hy_track_201505";
            //String sql = "select * from Text";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);

            System.out.println("-----------------");

            ArrayList<TrackClass> trackClassArrayList = DB2Array.ToArray(rs);

            Array2XML.ToXML(trackClassArrayList);

            rs.close();
            conn.close();

        } catch(ClassNotFoundException e) {


            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();


        } catch(SQLException e) {


            e.printStackTrace();


        } catch(Exception e) {


            e.printStackTrace();


        }
    }

    }

