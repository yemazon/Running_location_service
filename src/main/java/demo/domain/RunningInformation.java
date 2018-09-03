package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude
public class RunningInformation {

    @Id
    @GeneratedValue
    private final int userId;

    private String runningId;

    private double latitude;

    private double longitude;

    private double runningDistance;

    private double totalRunningTime;

    private int heartRate;

    private Date Timestamp = new Date();

    public RunningInformation(int userId) {
        this.userId = userId;
    }

    public RunningInformation() {
        userId = 0;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userInfo_username")),
            @AttributeOverride(name = "address", column = @Column(name = "userInfo_address"))
    })
    private UserInfo userInfo = new UserInfo();

    //public RunningInformation(@JsonProperty("runningId") String runningId) {
    //    this.runningId = runningId;
    //}
}