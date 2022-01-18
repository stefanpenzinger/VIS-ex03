package at.fh.hagenberg.mc.vis.task3_1.a;

import java.io.*;

/**
 * Task 3.1a
 * A simple class to extract information of the xml file and place it in the corresponding container
 */
public class DontDoItLikeThat {
    public static void main(String[] _args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\task_3_1_a\\WGS.xml"));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null ) {
                sb.append(line).append("\n");
            }

            String xml = sb.toString();

            int startLatitude = xml.lastIndexOf("<latitude>");
            int endLatitude = xml.indexOf("</latitude>");
            float latitude = Float.parseFloat(xml.substring(startLatitude, endLatitude).replace("<latitude>", ""));

            int startLongitude = xml.lastIndexOf("<longitude>");
            int endLongitude = xml.indexOf("</longitude>");
            float longitude = Float.parseFloat(xml.substring(startLongitude, endLongitude).replace("<longitude>", ""));

            WGS wgs = new WGS(latitude, longitude);

            System.out.println(wgs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
