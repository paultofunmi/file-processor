package com.example.fileprocessor.reader.staff.out;

public class StaffUpgradeProcess {

    private String processName;
    private String taskName;

    private InputParameters inputParameters;

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

    public InputParameters getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(InputParameters inputParameters) {
        this.inputParameters = inputParameters;
    }

    @Override
    public String toString() {
        return "StaffUpgradeProcess{" +
                "processName='" + processName + '\'' +
                ", taskName='" + taskName + '\'' +
                ", inputParameters=" + inputParameters +
                '}';
    }
}
