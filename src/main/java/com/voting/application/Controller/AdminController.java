package com.voting.application.Controller;

import com.voting.application.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @GetMapping("/results")
    public ResponseEntity<Map<String, Long>> getResults() {
        return ResponseEntity.ok(adminService.getLiveResults());
    }

}
