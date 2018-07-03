package masterSpringMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class SocialApiConfig {

    @Autowired
    private Environment env;

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Twitter twitter(){
        String consumerKey = env.getProperty("spring.social.twitter.consumerKey");
        String consumerSecret = env.getProperty("spring.social.twitter.consumerSecret");
        TwitterTemplate twitterTemplate = new TwitterTemplate(consumerKey, consumerSecret);
        return twitterTemplate;
    }
}
