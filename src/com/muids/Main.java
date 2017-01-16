package com.muids;

import twitter4j.*;

import java.util.List;

public class Main {

    public static void main(String args[]) throws Exception {

        //sendTweet("Hello it's me #muidstim");
        readTimeline();
        searchTweets("donald trump");


    }

    private static void readTimeline() throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();

        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }


    private static void searchTweets(String searchTerm) throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query(searchTerm);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("\n@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    private static void sendTweet(String tweet)throws Exception {
        // The factory instance is re-useable and thread safe.
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }

}
