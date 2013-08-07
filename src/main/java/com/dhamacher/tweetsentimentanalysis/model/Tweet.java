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
package com.dhamacher.tweetsentimentanalysis.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import twitter4j.User;

/**
 *
 * @author Daniel Hamacher
 * @version 1.0
 */
@Entity
@NamedQuery(name = "findAllTweets",
        query = "SELECT t FROM Tweet t")
public class Tweet {
    
    @Id 
    @GeneratedValue
    private long id;
    
    @Column(name = "tweet_id")
    private long tweetId;
    
    private String source;
    
    @Column(name = "twitter_user")
    private User user;
    
    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    
    @Column(name = "is_retweet")
    private boolean isRetweet;
    
    private String text;
    
    @Column(name = "search_token")
    private String searchToken;

    public Tweet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isIsRetweet() {
        return isRetweet;
    }

    public void setIsRetweet(boolean isRetweet) {
        this.isRetweet = isRetweet;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSearchToken() {
        return searchToken;
    }

    public void setSearchToken(String searchToken) {
        this.searchToken = searchToken;
    }    
}
