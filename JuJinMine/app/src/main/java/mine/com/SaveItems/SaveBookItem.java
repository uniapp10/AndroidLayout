package mine.com.SaveItems;

/**
 * Created by zhudongdong on 2018/1/11.
 */

public class SaveBookItem {
    String name;
    String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public SaveBookItem(String name, String author) {
        this.name = name;
        this.author = author;
    }

}
