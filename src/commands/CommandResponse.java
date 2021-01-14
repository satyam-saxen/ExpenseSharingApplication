package commands;

public class CommandResponse {
    private String responseDescription;
    private Boolean status;

    public CommandResponse() {
    }

    public CommandResponse(String responseDescription, Boolean status) {
        this.responseDescription = responseDescription;
        this.status = status;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
