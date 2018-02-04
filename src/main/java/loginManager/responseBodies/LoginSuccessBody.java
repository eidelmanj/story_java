package loginManager.responseBodies;

import responseObjects.ResponseBody;

public class LoginSuccessBody implements ResponseBody {

    public LoginSuccessBody(String sessionId) {
        this.sessionId = sessionId;
    }

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


}
