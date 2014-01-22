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
 
	Document doc;
	try {
 
		// need http protocol
		doc = Jsoup.connect("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=").get();
 
		// get page title
		String title = doc.title();
		System.out.println("title : " + title);
 
		// get all links
		Elements links = doc.select("a[href]");
		for (Element link : links) {
 
			// get the value from href attribute
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
 
		}
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
  }
 
}
