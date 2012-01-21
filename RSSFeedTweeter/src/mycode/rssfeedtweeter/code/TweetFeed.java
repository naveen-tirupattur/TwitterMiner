package mycode.rssfeedtweeter.code;

import java.util.concurrent.TimeUnit;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class TweetFeed
{
  private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1/statuses/update.json";
	

  private static final String GET_TIME_LINE = "https://api.twitter.com/1/statuses/home_timeline.json?include_entities=true"; 
  
  public static void main(String[] args)
  {
    OAuthService service = new ServiceBuilder()
                                .provider(TwitterApi.class)
                                .apiKey("vUBdIal10yUwaVEr6t6Bg")
                                .apiSecret("EggoFxehB1mUE2yaTkRiIIexu7sLtVTv0jG14pum7Y")
                                .build();
    
    
    Token accessToken = new Token("53021580-rIra9b6hVB4i4P3xEra80Gjd1QEWHIMT1BkRUYrlg", "hhjat7ypNe3AzurcRMbSLq7DYD8d07JiDFzK7UCYTg");
    
    OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);    
    System.out.println("Request: "+request);
    request.addBodyParameter("status","Hello");
    service.signRequest(accessToken, request);
    request.setConnectTimeout(10, TimeUnit.SECONDS);    
    Response response = request.send();
    System.out.println(response.getBody());

    
    
  }

}