package JUC.c1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/14 15:30
 */
public class Downloader {
    public static List<String> download() throws IOException{
        HttpURLConnection conn = (HttpURLConnection) new URL("https://www.baidu.com/").openConnection();
        List<String> list = new ArrayList<>();

        try(BufferedReader reader
                = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine())!=null){
                list.add(line);
            }
        }
        return list;
    }
}
