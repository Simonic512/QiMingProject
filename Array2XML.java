import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by simon on 15/11/19.
 */
public class Array2XML {

    public static void ToXML(ArrayList<TrackClass> list) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement("Track");
        document.setRootElement(root);
        root.addAttribute("DataBaseName", "Track2015乱七八糟的").addAttribute("Date", "18/11/2015");
        Iterator<TrackClass> iter = list.iterator();
        while(iter.hasNext()) {
            TrackClass track = iter.next();
            int CID = track.getCID();
            int year = track.getYear();

            //给根节点添加属性
           // root.addAttribute("DataBaseName", "Track2015乱七八糟的").addAttribute("Date", "18/11/2015");

            //给根节点添加孩子节点
            Element element = root.addElement("Car"+" ");
            element.addElement("CID").addText(String.valueOf(CID));
            element.addElement("YEAR").addText(String.valueOf(year));
        }

           /*添加节点示例
            Element element2 = root.addElement("学生");

            element2.addElement("姓名").addAttribute("婚姻", "单身").addText("小红").addElement("爱好").addText("唱歌");
            element2.addElement("年龄").addText("22");  */

            //把生成的xml文档存放在硬盘上  true代表是否换行

            OutputFormat format = new OutputFormat("    ",true);
            format.setEncoding("GBK");//设置编码格式
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("Person.xml"),format);

            xmlWriter.write(document);
        try {
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
