package Pojo;

import java.util.Objects;

public class CodesOfConductPOJO {

    private String key;
    private String name;
    private Objects html_url;
    private String url;


    @Override
    public String toString() {
        return "CodesOfConductPOJO{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", html_url=" + html_url +
                ", url='" + url + '\'' +
                '}';
    }

    public CodesOfConductPOJO() {

    }

    public CodesOfConductPOJO(String key, String name, Objects html_url, String url) {
        this.key = key;
        this.name = name;
        this.html_url = html_url;
        this.url = url;
    }


    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Objects getHtml_url() {
        return html_url;
    }

    public String getUrl() {
        return url;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHtml_url(Objects html_url) {
        this.html_url = html_url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
