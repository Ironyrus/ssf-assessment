package ssfassessment.cryptocompare.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class artObj implements Serializable {
    public ArrayList<artObj> Data;
    // public String Message;
    // public String HasWarning;
    //Within each item in data
    public String id;
    public String title;
    public String body;
    public String published_on;    
    public String url;
    public String imageurl;
    public String tags;
    public String categories;
    public String randomId;

    // public boolean checked = false;

    public artObj() {
        this.randomId = this.generateId(8);
    }

    public artObj(ArrayList<artObj> data, String id, String randomId, String title, String body, String published_on,
            String url, String imageurl, String tags, String categories) {
        Data = data;
        this.id = id;
        this.title = title;
        this.body = body;
        this.published_on = published_on;
        this.url = url;
        this.imageurl = imageurl;
        this.tags = tags;
        this.categories = categories;
        this.randomId = randomId;
    }





    public ArrayList<artObj> getData() {
        return Data;
    }

    public void setData(ArrayList<artObj> data) {
        Data = data;
    }

    public String getId() {
        return id;
    }

    private synchronized String generateId(int numchars) {
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < numchars) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, numchars);
    }

    // public String getPublished_on() {
    //     long temp = Integer.parseInt(published_on);
    //     Date date = new Date(temp*1000L);
    //     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    //     String strDate = dateFormat.format(date);
    //     return strDate;
    // }

    // public void setPublished_on(String published_on) {
    //     long temp = Integer.parseInt(published_on);
    //     Date date = new Date(temp*1000L);
    //     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    //     String strDate = dateFormat.format(date);
    //     this.published_on = strDate;
    // }

    public String getPublished_on() {
        return published_on;
    }

    public void setPublished_on(String published_on) {
        this.published_on = published_on;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRandomId() {
        return randomId;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    

    // public boolean isChecked() {
    //     return checked;
    // }

    // public void setChecked(boolean checked) {
    //     this.checked = checked;
    // }
    
    // @Override
    // public String toString() {
    //     return "Articles [Data=" + Data + ", HasWarning=" + HasWarning + ", Message=" + Message + ", body=" + body
    //             + ", categories=" + categories + ", id=" + id + ", imageurl=" + imageurl + ", published_on="
    //             + published_on + ", tags=" + tags + ", title=" + title + ", url=" + url + "]";
    // }
    
}
