/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkgetter;

/**
 *
 * @author danielwatson
 */
public class EventLink {
    
    private String link;
    private String title;
    
    public EventLink(String title, String link){
        this.title = title;
        this.link = link;
    }
    
    //possible stragey class for differnet URLs for us and uk etc
    public String getLink(){
        return link;
    }
    
    public String getTitlle(){
        return title;
    }
}