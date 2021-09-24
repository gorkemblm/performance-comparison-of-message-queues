package com.gorkem.kafkaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String uniqueId = UUID.randomUUID().toString();

    private String dateOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    private String tag;
    private String phoneNumber;
    private String dateOfUpdating;
    private boolean isActive;

    @Override
    public String toString() {
        return "BLNC{" +
                "uniqueId='" + uniqueId + '\'' +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", tag='" + tag + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfUpdating='" + dateOfUpdating + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isActive == user.isActive
                && uniqueId.equals(user.uniqueId)
                && dateOfCreation.equals(user.dateOfCreation)
                && tag.equals(user.tag)
                && phoneNumber.equals(user.phoneNumber)
                && dateOfUpdating.equals(user.dateOfUpdating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, dateOfCreation, tag, phoneNumber, dateOfUpdating, isActive);
    }
}
