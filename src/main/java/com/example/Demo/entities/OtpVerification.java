package com.example.Demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OtpVerification {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private int otp;
    private LocalDateTime createdAt;
	public OtpVerification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OtpVerification(Long id, String email, int otp, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.email = email;
		this.otp = otp;
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "OtpVerification [id=" + id + ", email=" + email + ", otp=" + otp + ", createdAt=" + createdAt + "]";
	}
    
    
    

}
