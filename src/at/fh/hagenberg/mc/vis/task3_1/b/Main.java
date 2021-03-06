package at.fh.hagenberg.mc.vis.task3_1.b;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Task 3.1b
 */
public class Main {
    public static void main(String[] _args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            WindDataHandler handler = new WindDataHandler();
            sp.parse(new File("src/task_3_1_b/string.xml"), handler);

            WindData windData = handler.getmWindData();
            System.out.println(windData);

        } catch (Exception _e) {
            System.out.println("parsing failed " + _e);
        }
    }
}
