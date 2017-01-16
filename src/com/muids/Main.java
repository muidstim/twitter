package com.muids;

import twitter4j.*;

import java.util.List;

public class Main {

    public static void main(String args[]) throws Exception {

    }

    /*
     This method reads from your timeline
     */
    private static void readHomeTimeline() throws Exception {

        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();

        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }


    /*
     This method reads from the specified user's timeline
     */
    private static void readUserTimeline(String user) throws Exception {

        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getUserTimeline(user);

        System.out.println("Showing user timeline for " + user);
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }


    /*
     This method searches Twitter using the given search term
     */
    private static void searchTweets(String searchTerm) throws Exception {

        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query(searchTerm);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("\n@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    /*
     This method sends a tweet
     */
    private static void sendTweet(String tweet)throws Exception {

        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }

}
