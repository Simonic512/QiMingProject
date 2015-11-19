import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by simon on 15/11/19.
 */
public class DB2Array{
    public static ArrayList<TrackClass> ToArray(ResultSet rs) throws SQLException {
        ArrayList<TrackClass> track = new ArrayList<>();
        int CID;
        int year;

        while(rs.next()) {

            TrackClass trackClass = new TrackClass();
            CID = new Integer(rs.getString("CID"));
            trackClass.setCID(CID);
            year = new Integer(rs.getString("T_Status"));
            trackClass.setYear(year);


            // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
            // 然后使用GB2312字符集解码指定的字节数组
            // name = new String(name.getBytes("ISO-8859-1"),"GB2312");

            // 输出结果
            track.add(trackClass);
            System.out.println(rs.getString("CID") + "\t" + trackClass.getCID());
            System.out.println(rs.getString("T_Status")+ "\t" + trackClass.getYear());

        }
        return track;
    }
}
