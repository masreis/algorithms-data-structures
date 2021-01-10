package net.ads.algorithms.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    private static final int HTTP_OK = 200;
    private static String urlEndpoint = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";
    private static Pattern pagePattern = Pattern.compile("\"page\":(.*),");
    private static Pattern totalPagesPattern = Pattern.compile("\"total_pages\":(.*?),");
    private static Pattern amountPattern = Pattern.compile("\"amount\":\"\\$(.*?)\",");
    private static Pattern dataPattern = Pattern.compile("\"data\":(.*)");
    private static Pattern locationIdPattern = Pattern.compile("\"location\":\\{\"id\"\\:(.*?),");
    private static Pattern ipPattern = Pattern.compile("\"ip\":\"(.*?)\\.");

    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
        double total = 0;
        try {
            int actualPage = 1;
            StringBuilder content = getContentFromApi(userId, actualPage);
            Matcher pageMatcher = pagePattern.matcher(content);
            Matcher totalPagesMatcher = totalPagesPattern.matcher(content);

            if (pageMatcher.find() && totalPagesMatcher.find()) {
                int totalPages = Integer.parseInt(totalPagesMatcher.group(1));

                while (actualPage <= totalPages) {
                    actualPage++;
                    Matcher dataMatcher = dataPattern.matcher(content);
                    if (dataMatcher.find()) {
                        String jsonRecords = dataMatcher.group(1);
                        String[] records = jsonRecords.split("\\},\\{");
                        total += Arrays.stream(records).filter(record -> isValid(record, locationId, netStart, netEnd))
                                .mapToDouble(record -> extractAmount(record)).sum();
                    }
                    content = getContentFromApi(userId, actualPage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (int) Math.round(total);
    }

    private static double extractAmount(String record) {
        try {
            Matcher amountMatcher = amountPattern.matcher(record);
            if (amountMatcher.find()) {
                String group = amountMatcher.group(1).replaceAll(",", "");
                System.out.println(group);
                return Double.parseDouble(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static boolean isValid(String record, int locationId, int netStart, int netEnd) {
        try {
            Matcher locationIdMatcher = locationIdPattern.matcher(record);
            Matcher ipMatcher = ipPattern.matcher(record);
            if (locationIdMatcher.find() && ipMatcher.find()) {
                int location = Integer.parseInt(locationIdMatcher.group(1));
                if (location != locationId) {
                    return false;
                }
                int ip = Integer.parseInt(ipMatcher.group(1));
                if (ip < netStart || ip > netEnd) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static StringBuilder getContentFromApi(int userId, int page) throws IOException {
        URL url = new URL(urlEndpoint + userId + "&page=" + page);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        StringBuilder content = new StringBuilder();
        if (con.getResponseCode() == HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        }
        return content;
    }

    public static void main(String[] args) {
        int result = new Test1().getTransactions(2, 8, 5, 50);
        System.out.println(result);
    }

}
