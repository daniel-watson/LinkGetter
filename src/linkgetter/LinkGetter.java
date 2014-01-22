/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkgetter;

import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


 
public class LinkGetter {
 
  public static void main(String[] args) {
 	try {
                String url = "http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=";
		//use Jsoup connect to point it to the correct page 
                //use .get or the get HTTP protocol toreturn the web page.
		Document doc = Jsoup.connect(url)
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
			System.out.println("\nLink : " + "http://www.runnersworld.co.uk" + link.attr("href"));
                        //int count = 0;
                        //while(count < 100000000){count++;}
			System.out.println("Race Title : " + link.text());
                        System.out.println(i++);
                        //count = 0;
		}

	} catch (IOException e) {
		e.printStackTrace();
	}
 
  }
 
}
