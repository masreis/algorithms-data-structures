package net.ads.algorithms.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestClientTest {
    private static String urlEndpoint = null;
    private static Pattern pagePattern = Pattern.compile("\"page\":\"([^,]*)\",");
    private static Pattern totalPagesPattern = Pattern.compile("\"total_pages\":([^,]*),");
    private static Pattern submissionCountPattern = Pattern.compile("\"submission_count\":([^,]*),");
    private static Pattern usernamePattern = Pattern.compile("\"username\":\"([^,]*)\",");

    public static void main(String[] args) {
        List<String> userNames = new RestClientTest().getUsernames(10);
    }

    public static List<String> getUsernames(int threshold) {

        List<String> result = new ArrayList<>();

        try {
            int actualPage = 1;
            StringBuilder content = getContentFromApi(actualPage);
            Matcher pageMatcher = pagePattern.matcher(content);
            Matcher totalPagesMatcher = totalPagesPattern.matcher(content);
            Matcher submissionCountMatcher = submissionCountPattern.matcher(content);
            Matcher usernameMatcher = usernamePattern.matcher(content);

            if (pageMatcher.find() && totalPagesMatcher.find()) {
                int totalPages = Integer.parseInt(totalPagesMatcher.group(1));

                while (actualPage <= totalPages) {
                    actualPage++;
                    pageMatcher = pagePattern.matcher(content);
                    totalPagesMatcher = totalPagesPattern.matcher(content);
                    submissionCountMatcher = submissionCountPattern.matcher(content);
                    usernameMatcher = usernamePattern.matcher(content);

                    while (usernameMatcher.find()) {
                        submissionCountMatcher.find();
                        String username = usernameMatcher.group(1);
                        String count = submissionCountMatcher.group(1);
                        if (Integer.parseInt(count) > threshold) {
                            result.add(username);
                        }

                    }
                    content = getContentFromApi(actualPage);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static StringBuilder getContentFromApi(int page) throws IOException {
        URL url = new URL(urlEndpoint + page);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        StringBuilder content = new StringBuilder();
        if (con.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        }
        return content;
    }

}
