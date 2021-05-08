package project.day20.homework.steps;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import project.day20.homework.objects.GSONParser;
import project.day20.homework.objects.Search;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class JUnitSteps {
    private static final String URI = "http://178.124.206.46:8001/app/ws/";

    GSONParser gsonParser = new GSONParser();
    private HttpResponse response;
    private String responseUser;
    private String userFromJson;


    public HttpResponse sendRequest(String username, boolean strict) throws URISyntaxException, IOException {
        Search search = new Search(username, strict);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(URI);
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(GSONParser.fromGSON(search)));
        response = client.execute(request);
        return response;
    }

    public String getResponse() throws IOException {
        Gson gson = new Gson();
        HashMap map = gson.fromJson(EntityUtils.toString(response.getEntity()), HashMap.class);
        for (Object s : map.values()) {
            if (!s.toString().equals("0")) {
                responseUser = s.toString();
                return responseUser;
            }
        }
        return null;
    }

    public void compareAccounts() {
        Assert.assertEquals(responseUser, userFromJson);
    }

    public String getUser(int numberOfUser) {
        try {
            userFromJson = gsonParser.parserGSON(numberOfUser);
            return userFromJson;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
