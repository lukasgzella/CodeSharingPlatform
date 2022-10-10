package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Snippet {

    private String code;
    private String date;

    public Snippet() {
    }

    public Snippet(String code, String date) {
        this.date = date;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
