package com.example.dvtweatherapplication;

import com.google.gson.annotations.SerializedName;

public class ResultResponseModel {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("severity")
    private String severity;

    public ResultResponseModel(String code, String message, String severity) {
        this.code = code;
        this.message = message;
        this.severity = severity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
