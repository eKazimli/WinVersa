package com.example.WinVersa.controller;

import com.example.WinVersa.entity.Admin;
import com.example.WinVersa.service.AdminService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminController {
    AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Admin admin) {
        Admin save = adminService.create(admin);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        adminService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<?> active(@PathVariable Long id) {
        adminService.active(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByAdminId(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.findByAdminId(id));
    }
}
