package com.aditya.Department_service.controller;

import com.aditya.Department_service.model.Department;
import com.aditya.Department_service.model.DepartmentResponseDTO;
import com.aditya.Department_service.model.EmployeeDTO;
import com.aditya.Department_service.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/allDepartments")
    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    @PostMapping("/addDepartment")
    public Mono<ResponseEntity<DepartmentResponseDTO>> addDepartment(@RequestBody Department department){
        return webClientBuilder.build().get()
                .uri("http://localhost:8081/employees/"+department.getManagerId())
                .retrieve()
                .bodyToMono(EmployeeDTO.class)
                .map(employeeDTO -> {
                    departmentRepo.save(department);

                    DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();
                    responseDTO.setDeptId(department.getDeptId());
                    responseDTO.setDeptName(department.getDeptName());
                    responseDTO.setManagerId(department.getManagerId());

                    responseDTO.setEmpName(employeeDTO.getEmpName());
                    responseDTO.setEmpSalary(employeeDTO.getEmpSalary());
                    return ResponseEntity.ok(responseDTO);
                });
    }
}
























