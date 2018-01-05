package mine.com.FourItems.ContentProvider;

/**
 * Created by zhudongdong on 2018/1/4.
 */

public class ContactItem {
    String name;

    public ContactItem(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    String number;
}
