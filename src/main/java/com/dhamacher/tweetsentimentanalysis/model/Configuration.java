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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Daniel Hamacher
 * @version 1.0
 */
@Entity
public class Configuration {
    
    @Id
    @GeneratedValue
    private long id;
        
    @Column(name = "consumer_key")
    private String oAuthConsumerKey;
    
    @Column(name = "consumer_secret")
    private String oAuthConsumerSecret;
    
    @Column(name = "access_token")
    private String accessToken;
    
    @Column(name = "access_token_secret")
    private String accessTokenSecret;
    
    @Column(name = "debug")
    private Boolean debugEnabled;

    public Configuration() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getoAuthConsumerKey() {
        return oAuthConsumerKey;
    }

    public void setoAuthConsumerKey(String oAuthConsumerKey) {
        this.oAuthConsumerKey = oAuthConsumerKey;
    }

    public String getoAuthConsumerSecret() {
        return oAuthConsumerSecret;
    }

    public void setoAuthConsumerSecret(String oAuthConsumerSecret) {
        this.oAuthConsumerSecret = oAuthConsumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public Boolean getDebugEnabled() {
        return debugEnabled;
    }

    public void setDebugEnabled(Boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }    
}
