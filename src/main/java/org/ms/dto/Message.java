package org.ms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Сообщение для передачи данных между микросервисами (для одного цикла взаимодействия)
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Message {

    /*
     * Идентифиĸатор цикла (сеанса) взаимодействия, задаваемый MS1,
     * */
    @JsonProperty("session_id")
    private int sessionId;

    /*
     * Время прохождения сообщения через MS1 в начале
     * */
    @JsonProperty("service1_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date service1Timestamp;


    /*
     * Время прохождения сообщения через MS2
     * */
    @JsonProperty("service2_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date service2Timestamp;

    /*
     * Время прохождения сообщения через MS3
     * */
    @JsonProperty("service3_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date service3Timestamp;

    /*
     * Время прохождения сообщения через MS1 в конце
     * */
    @JsonProperty("end_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date endTimestamp;

    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return "Message{" +
                "sessionId=" + sessionId +
                ", service1Timestamp=" + (service1Timestamp != null ? formatDate.format(service1Timestamp) : "null") +
                ", service2Timestamp=" + (service2Timestamp != null ? formatDate.format(service2Timestamp) : "null") +
                ", service3Timestamp=" + (service3Timestamp != null ? formatDate.format(service3Timestamp) : "null") +
                ", endTimestamp=" + (endTimestamp != null ? formatDate.format(endTimestamp) : "null") +
                '}';
    }
}
