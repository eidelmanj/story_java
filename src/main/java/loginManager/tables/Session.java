package loginManager.tables;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String sessionId;

    @ManyToOne(targetEntity=User.class,  fetch=FetchType.EAGER)
    private User user;

    @Column(name = "startTime", columnDefinition="DATETIME")
    private Timestamp startTime;
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
