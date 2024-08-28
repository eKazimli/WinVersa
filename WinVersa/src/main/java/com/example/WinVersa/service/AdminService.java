package com.example.WinVersa.service;

import com.example.WinVersa.entity.Admin;
import com.example.WinVersa.repository.AdminRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminService {
    AdminRepository adminRepository;

    public Admin create(Admin admin) {
        admin.setUsername(admin.getUsername());
        admin.setPassword(admin.getPassword());
        return adminRepository.save(admin);
    }

    public void delete(Long id) {
        Admin admin = adminRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Admin type not found"));
        admin.setIsActive(false);
        adminRepository.save(admin);
    }

    public void active(Long id) {
        Admin admin = adminRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Admin type not found"));
        admin.setIsActive(true);
        adminRepository.save(admin);
    }

    public Admin findByAdminId(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }
}
