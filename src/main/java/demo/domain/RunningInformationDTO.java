package demo.domain;

import lombok.Data;

@Data
public class RunningInformationDTO{

    private enum healthWarningLevel{
        HIGH, LOW, NORMAL;
    }
    private String runningId;
    private double totalRunningTime;
    private Integer heartRate;
    private int userId;
    private String userName;
    private String userAddress;
    private healthWarningLevel healthWarningLevel;

    public RunningInformationDTO(RunningInformation runningInformation) {
        this.userId = runningInformation.getUserId();
        this.runningId = runningInformation.getRunningId();
        this.totalRunningTime = runningInformation.getTotalRunningTime();
        this.heartRate = runningInformation.getHeartRate();
        if (heartRate > 120 )
            this.healthWarningLevel = healthWarningLevel.HIGH;
        else if (heartRate >=60 && heartRate <=75)
            this.healthWarningLevel = healthWarningLevel. LOW;
        else
            this.healthWarningLevel = healthWarningLevel.NORMAL;
        this.userName = runningInformation.getUserInfo().getUsername();
        this.userAddress = runningInformation.getUserInfo().getAddress();
    }
}