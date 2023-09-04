//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.apptasticsoftware:rssreader:3.5.0
//DEPS com.google.code.gson:gson:2.8.6
//JAVA_OPTIONS --add-opens java.base/java.time=ALL-UNNAMED

import com.apptasticsoftware.rssreader.RssReader;
import com.apptasticsoftware.rssreader.module.itunes.ItunesRssReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static java.lang.System.out;
public class main {

    public static void main(String[] args) {

        
        try {
            new ItunesRssReader().read("https://feeds.listenbox.app/rss/9w4VBtq9s1v/video.rss")
                .forEach(item -> {
                    out.printf("%s (%s): %s\n", 
                        item.getTitle().orElse("No title"),
                        item.getLink().orElse(""),
                        item.getItunesSubtitle().orElse(""));

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String prettyJson = gson.toJson(item);
                    out.println(prettyJson);
                    
                
                        
                }
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
