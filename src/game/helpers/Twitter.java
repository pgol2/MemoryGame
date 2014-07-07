package game.helpers;

import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by pawel on 07/07/14.
 */
public class Twitter {

    public Twitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Cg72ralgXBm48q37gBQxpKjko")
                .setOAuthConsumerSecret("f0NiOJ3qmAjRbv3pWAtv4qa9VEy99JXMAYXJpRte11vs8HyNt1")
                .setOAuthAccessToken("2609930672-YDBcEL5rfDHQAaQcZUnRn5J1zWl5t5xSYemSl0o")
                .setOAuthAccessTokenSecret("RoDdnr81NIAocq8IszF4RJLS0oxH7TNwzfoqrZyftBrsY");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = (Twitter) tf.getSingleton();




    }
}
