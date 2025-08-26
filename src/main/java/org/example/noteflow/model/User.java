package org.example.noteflow.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String gender;
    private LocalDateTime createdAt;
    private String subscriptionType;
    private boolean active;

    // Konstruktor leer
    public User() {}

    // Getter und Setter
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getBirthday() { return birthday; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getSubscriptionType() { return subscriptionType; }
    public void setSubscriptionType(String subscriptionType) { this.subscriptionType = subscriptionType; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
