package facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {

  public String getAttributeValueFromJson(String urlString, String attributeName)
      throws IOException, IllegalArgumentException {

    String json = getJson(urlString);
    return extractAttribute(json, attributeName);
  }

  private String getJson(String urlString) throws IOException {
    URL url = new URL(urlString);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(con.getInputStream()))) {

      StringBuilder sb = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }

      return sb.toString();

    } catch (IOException e) {
      throw new IOException("Failed to fetch data", e);
    } finally {
      con.disconnect();
    }
  }

  private String extractAttribute(String json, String attributeName)
      throws IllegalArgumentException {

    try {
      JSONParser parser = new JSONParser();
      JSONObject obj = (JSONObject) parser.parse(json);

      Object value = obj.get(attributeName);
      if (value == null) {
        throw new IllegalArgumentException("Attribute not found");
      }

      return value.toString();

    } catch (Exception e) {
      throw new IllegalArgumentException("JSON parsing failed", e);
    }
  }
}
