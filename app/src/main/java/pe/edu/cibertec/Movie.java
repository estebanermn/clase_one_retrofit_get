package pe.edu.cibertec;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("Title")
    public String title;

    @SerializedName("Year")
    public String year;

    @SerializedName("Plot")
    public String plop;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlop() {
        return plop;
    }

    public void setPlop(String plop) {
        this.plop = plop;
    }
}
