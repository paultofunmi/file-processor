package com.example.fileprocessor.reader.staff;

public class StaffUpgradeProcessResponseDto {

    private String processName;

    private String taskName;

    private String applicationId;

    private String failureReason;

    public StaffUpgradeProcessResponseDto() {
    }

    public StaffUpgradeProcessResponseDto(String processName, String taskName, String applicationId, String failureReason) {
        this.processName = processName;
        this.taskName = taskName;
        this.applicationId = applicationId;
        this.failureReason = failureReason;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
