package ssfassessment.cryptocompare.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class artObj {
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
    // public boolean checked = false;

    public artObj() {
    }

    public artObj(ArrayList<artObj> data, String id, String published_on, String title, String url, String imageurl,
            String body, String tags, String categories) {
        Data = data;
        this.id = id;
        this.published_on = published_on;
        this.title = title;
        this.url = url;
        this.imageurl = imageurl;
        this.body = body;
        this.tags = tags;
        this.categories = categories;
    }



    public ArrayList<artObj> getData() {
        return Data;
    }

    public void setData(ArrayList<artObj> data) {
        Data = data;
    }

    // public String getMessage() {
    //     return Message;
    // }

    // public void setMessage(String message) {
    //     Message = message;
    // }

    // public String getHasWarning() {
    //     return HasWarning;
    // }

    // public void setHasWarning(String hasWarning) {
    //     HasWarning = hasWarning;
    // }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublished_on() {
        int temp = Integer.parseInt(published_on);
        Date date = new Date(temp*1000L);
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
