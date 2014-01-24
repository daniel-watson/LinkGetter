/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * http://www.mkyong.com/java/jsoup-html-parser-hello-world-examples/
 */
package linkgetter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class LinkGetter {
    //private String url = null;
    public static void main(String[] args) {
        try {
            String onlineUrl = "http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=&onlineEntryTickBox=1";
            String url = "http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=";
            //use Jsoup connect to point it to the correct page
            //use .get or the get HTTP protocol toreturn the web page.
            Document doc = Jsoup.connect(onlineUrl)
                    .userAgent("Mozilla")
                    .timeout(3000)
                    .get();
            // get page title
            String title = doc.title();
            
            //Finds matching elements. it will look in for a class named evntTitle.
            //It will then save any <ahref> links to the list links
            Elements links = doc.select(".evntTitle > a[href]");
            System.out.println(links.size());
            
            //print the title of the web page
            System.out.println("title : " + title);
            
            //counter ensure i only recieve 10 links
            int i = 1;
            for (Element link : links) {
                // get the value from href attribute
                //the if statement checks whether the link is for a details page or and online entry form
                //returning online detail page links
                if( link.attr("href").contains("viewevent") ){
                    System.out.println("\nLink : " + "http://www.runnersworld.co.uk" + link.attr("href"));
                    System.out.println("Race Title : " + link.text());
                    System.out.println(i++);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
