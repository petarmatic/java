/**import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Obavijest {
    public static void posaljiPorukuOGresci() {
        String webhookUrl = "https://hooks.slack.com/services/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"; // Postavi svoj Webhook URL ovdje
        String porukaOGresci = "Došlo je do greške u aplikaciji!";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(webhookUrl);

            // Postavite JSON tijelo zahtjeva sa informacijama o grešci
            String jsonPayload = "{\"text\":\"" + porukaOGresci + "\"}";
            StringEntity entity = new StringEntity(jsonPayload);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json");

            // Izvršite zahtjev
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    System.out.println("Obavijest poslana na Slack!");
                    EntityUtils.consume(responseEntity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        posaljiPorukuOGresci();
    }
}
*/