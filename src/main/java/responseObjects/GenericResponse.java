package responseObjects;

public class GenericResponse {

    private String status;
    private String message;

    private ResponseBody responseBody;

    public GenericResponse(String status, String message, ResponseBody responseBody) {
        this.status = status;
        this.message = message;
        this.responseBody = responseBody;
    }

    public GenericResponse() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

}
