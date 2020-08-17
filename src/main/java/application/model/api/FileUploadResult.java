package application.model.api;

public class FileUploadResult extends BaseApiResult {
    private String Link;

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
