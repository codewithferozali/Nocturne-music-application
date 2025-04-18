package com.example.Demo.controller;

import java.time.LocalDateTime;
import java.util.Random;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Demo.entities.OtpVerification;
import com.example.Demo.entities.Users;
import com.example.Demo.repositories.OtpRepository;
import com.example.Demo.repositories.UsersRepository;
import com.example.Demo.services.EmailService;



@Controller
@Transactional
public class forgetController {  // Class name should start with uppercase (convention)
    
    @Autowired
     EmailService emailService;
    
    @Autowired
     UsersRepository userRepository;  // Changed from UsersRepository to UserRepository (common convention)
    
    @Autowired
     OtpRepository otpRepository;  // Changed from OtpVerification to OtpRepository
    
   
    
    private Random random = new Random();
    
    @GetMapping("/map-forget-password")
    public String forgotPasswordForm() {
        return "forgetpassword";
    }
    
    @PostMapping("/send-otp")
    public String sendOTP(@RequestParam("email") String email, Model model) {
        try {
            // Validate email
            if (!isValidEmail(email)) {
                model.addAttribute("error", "Invalid email format");
                return "forgot-password";
            }

            // Generate 6-digit OTP
            int otp = 100000 + random.nextInt(900000);
            
            // Save OTP (transactional)
            otpRepository.deleteByEmail(email);
            OtpVerification otpEntry = new OtpVerification();
            otpEntry.setEmail(email);
            otpEntry.setOtp(otp);
            otpEntry.setCreatedAt(LocalDateTime.now());
            otpRepository.save(otpEntry);
            
            // Send email
            boolean emailSent = emailService.sendEmail(
                "Your OTP Code",
                "Your OTP is: " + otp,
                email
            );

            if (emailSent) {
                model.addAttribute("email", email);
                return "verify-otp";
            } else {
                model.addAttribute("error", "Failed to send OTP");
                return "forgot-password";
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred");
            return "forgot-password";
        }
    }

    @PostMapping("/verify-otp")
    public String verifyOTP(
        @RequestParam("email") String email,
        @RequestParam("otp") int otp,
        Model model) {
        
        try {
            OtpVerification otpEntry = otpRepository.findByEmailAndOtp(email, otp);
            
            if (otpEntry == null) {
                model.addAttribute("error", "Invalid OTP");
                model.addAttribute("email", email);
                return "verify-otp";
            }
            
            // Check expiration (10 minutes)
            if (otpEntry.getCreatedAt().plusMinutes(10).isBefore(LocalDateTime.now())) {
                otpRepository.delete(otpEntry);
                model.addAttribute("error", "OTP expired");
                model.addAttribute("email", email);
                return "verify-otp";
            }
            
            // Valid OTP
            otpRepository.delete(otpEntry);
            model.addAttribute("email", email);
            return "resetPassword";
        } catch (Exception e) {
            model.addAttribute("error", "Verification failed");
            return "verify-otp";
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    
    
    
    //reset password
   // @PostMapping("/reset-password")
    @PostMapping("/reset-password")
    public String resetPassword(
        @RequestParam("email") String email,
        @RequestParam("newpassword") String newPassword,
        @RequestParam("confirmpassword") String confirmPassword,
        Model model) {
        
        // Validate passwords match
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            model.addAttribute("email", email);
            return "resetPassword";
        }
        
        // Validate password strength
        if (newPassword.length() < 8) {
            model.addAttribute("error", "Password must be at least 8 characters");
            model.addAttribute("email", email);
            return "resetPassword";
        }
        
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "User not found");
            return "resetPassword";
        }
        
        // Update password (using PasswordEncoder is recommended)
        user.setPassword(newPassword); // Or use your preferred encryption method
        userRepository.save(user);
        
        return "login";
    }
    
    
    
    
    
}
	


