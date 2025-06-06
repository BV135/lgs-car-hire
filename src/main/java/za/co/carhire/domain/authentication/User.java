package za.co.carhire.domain.authentication;

import jakarta.persistence.*;

import java.time.LocalDate;

/* User.java

     User POJO class

     Author: Bonga Velem (220052379)

     Date: 11 May 2025 */
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private Integer idNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column
    private String licenseNumber;

    public User() {
    }

    public User(Builder builder) {
        this.userId = builder.userId;
        this.idNumber = builder.idNumber;
        this.name = builder.name;
        this.email = builder.email;
        this.dateOfBirth = builder.dateOfBirth;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
        this.licenseNumber = builder.licenseNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", idNumber=" + idNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }

    public static class Builder{

        private Integer userId;

        private Integer idNumber;

        private String name;

        private String email;

        private LocalDate dateOfBirth;

        private String phoneNumber;

        private String password;

        private String licenseNumber;

        public Builder setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder setIdNumber(Integer idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setLicenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
            return this;
        }

        public Builder copy(User user){
            this.userId =  user.userId;
            this.idNumber = user.idNumber;
            this.name = user.name;
            this.email = user.email;
            this.dateOfBirth = user.dateOfBirth;
            this.phoneNumber = user.phoneNumber;
            this.password = user.password;
            this.licenseNumber = user.licenseNumber;
            return this;

        }

        public User build(){
            return new User(this);
        }




    }
}
