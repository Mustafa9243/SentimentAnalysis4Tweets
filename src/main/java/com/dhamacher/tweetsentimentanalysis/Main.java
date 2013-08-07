/* SentimentAnalysis4Tweets uses Sentiment Analysis on Tweets with SVM.
 * 
 * Copyright (C) 2013  Daniel Hamacher
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dhamacher.tweetsentimentanalysis;

import com.dhamacher.tweetsentimentanalysis.model.Tweet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Daniel Hamacher
 * @version 1.0
 */
public class Main {

    /* To gain access to twitter */
    private static final TwitterFactory twitterFactory =
            new TwitterFactory(buildConfig());
    private static final Twitter twitter = twitterFactory.getInstance();
    /* Used to manage the entities */
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Tweet");
    private static final EntityManager em = emf.createEntityManager();

    public static void main(String args[]) {
        try {
            license();
            /* Prompt for Search token */
            Scanner in = new Scanner(System.in);
            System.out.print("Type in the search query: ");
            Query searchToken = new Query(in.nextLine());

            /* Set maximum count */
            searchToken.setCount(1500);

            /* Send search request to Twitter and receive List<> of results */
            QueryResult result = twitter.search(searchToken);

            /* Notify user of the result */
            System.out.println("Amount of tweets pulled for \"" + searchToken.getQuery() + "\": " + result.getTweets().size());

            persistTweet(result, searchToken.getQuery());
            end();

        } catch (TwitterException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Configuration buildConfig() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                /**
                 * Go to https://dev.twitter.com/ -> Sign in -> create App 
                 * -> use the data given at the end of App creation
                 * You need:
                 * (1) Consumer Key
                 * (2) Consumer Secret
                 * (3) Access Token
                 * (4) Access Token Secret
                 */                
                .setOAuthConsumerKey("*************************")
                .setOAuthConsumerSecret("****************************")
                .setOAuthAccessToken("***************************************")
                .setOAuthAccessTokenSecret("****************************************");
        return cb.build();
    }

    private static void persistTweet(QueryResult result, String token) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (Status status : result.getTweets()) {
            Tweet entity = new Tweet();
            entity.setTweetId(status.getId());
            entity.setSearchToken(token);
            entity.setCreatedOn(status.getCreatedAt());
            entity.setIsRetweet(status.isRetweet());
            entity.setSource(status.getSource());
            entity.setUser(status.getUser());
            entity.setText(status.getText());
            em.persist(entity);
        }
        tx.commit();
    }

    private static void end() {
        em.close();
        emf.close();
    }

    private static void license() {
        System.out.println("SentimentAnalysis4Tweets  Copyright (C) 2013  Daniel Hamacher\n"
                + "\n"
                + "    This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.\n"
                + "    This is free software, and you are welcome to redistribute it\n"
                + "    under certain conditions; type `show c' for details.");
    }
}