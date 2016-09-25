package example.com.movieplaylist.Recycler;

/**
 * Created by mher on 9/25/16.
 */
public class Movie {

    private String name;
    private String description;
    private int image;


    public Movie(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getImage() {
        return image;
    }
}
