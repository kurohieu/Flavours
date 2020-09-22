package application.model.viewmodel.common;


public class BannerVM {
    private String link;
    private String altText;
    private String imageUrl;
    private String name;
    private int id;

    public BannerVM(String link, String altText, String imageUrl,String name,int id) {
        this.link = link;
        this.altText = altText;
        this.imageUrl = imageUrl;
        this.name = name;
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
