package com.project.controleer;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.CertificationRequestDto;
import com.project.dto.CertificationResponseDto;
import com.project.service.CertificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/certifications")
@RequiredArgsConstructor
public class CertificationController {

    private final CertificationService certificationService;

    @PostMapping
    public CertificationResponseDto add(@RequestBody CertificationRequestDto dto) {
        return certificationService.addCertification(dto);
    }

    @GetMapping("/user/{userId}")
    public List<CertificationResponseDto> getByUser(@PathVariable Long userId) {
        return certificationService.getByUser(userId);
    }

    @PutMapping("/{id}")
    public CertificationResponseDto update(
            @PathVariable Long id,
            @RequestBody CertificationRequestDto dto) {

        return certificationService.updateCertification(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        certificationService.deleteCertification(id);
        return "Deleted successfully";
    }

    @PutMapping("/{id}/renew")
    public CertificationResponseDto renew(
            @PathVariable Long id,
            @RequestParam String newDate) {

        return certificationService.renewCertification(id, LocalDate.parse(newDate));
    }
}
