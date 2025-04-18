package com.example.Demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Demo.entities.OtpVerification;

public interface OtpRepository extends JpaRepository<OtpVerification, Long> {
    //OtpVerification findByEmailAndOtp(String email, int otp);
    //void deleteByEmail(String email);
    
    // Add this method for deleting by entity
    void delete(OtpVerification otpVerification);
    
    // Add method for cleaning expired OTPs
    @Modifying
    @Query("DELETE FROM OtpVerification o WHERE o.email = :email")
    void deleteByEmail(@Param("email") String email);
    
    @Query("SELECT o FROM OtpVerification o WHERE o.email = :email AND o.otp = :otp")
    OtpVerification findByEmailAndOtp(@Param("email") String email, @Param("otp") int otp);
}
