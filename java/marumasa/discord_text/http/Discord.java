package marumasa.discord_text.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;


public class Discord {

    String URL = "http://localhost:3210/";


    public void post(String name, String text, UUID uuid) throws IOException {

        String JSON = "{\"name\":\"" + name + "\",\"text\":\"" + text + "\",\"uuid\":\"" + uuid + "\"}";

        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        conn.connect();
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print(JSON);
        ps.close();
        if (conn.getResponseCode() != 200) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
    }
}