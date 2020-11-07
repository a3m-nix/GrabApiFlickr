/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unama.grabapi;

/**
 *
 * @author abdulrahim
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unama.grabapi.Flickr;
import com.unama.grabapi.Item;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abdulrahim
 */
public class MyApp {
    public static void main(String[] args) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        URL url;
        try {
            url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1");
            Flickr flickr = objectMapper.readValue(url, Flickr.class);
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            System.out.print("Flicker : "+flickr.getTitle());
            for(Item item : flickr.getItems()){
                System.out.println(item.getAuthor());
            }
        } catch (MalformedURLException ex) {
            System.out.print("Error "+ex.toString());
            //Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
