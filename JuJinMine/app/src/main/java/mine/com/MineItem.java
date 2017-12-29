package mine.com;

/**
 * Created by zhudongdong on 2017/12/28.
 */

public class MineItem {
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    private String imageName;
    private String titleName;

        public MineItem(String imageName, String titleName){
            this.imageName = imageName;
            this.titleName = titleName;
        }
}
