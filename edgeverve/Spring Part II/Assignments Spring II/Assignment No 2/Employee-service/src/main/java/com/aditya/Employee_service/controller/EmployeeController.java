package com.aditya.Employee_service.controller;

import com.aditya.Employee_service.model.DepartmentDTO;
import com.aditya.Employee_service.model.Employee;
import com.aditya.Employee_service.model.EmployeeResponseDTO;
import com.aditya.Employee_service.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/allEmployees")
    public List<Employee> allEmployees(){
        return employeeRepo.findAll();
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") Long empId){
        Employee employee = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("employee ID Not Found: "+empId ));
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/addEmployee")
    public Mono<ResponseEntity<EmployeeResponseDTO>> addDepartment(@RequestBody Employee employee){
        return webClientBuilder.build().get()
                .uri("http://localhost:8082/departments/"+ employee.getDeptId())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .map(departmentDTO -> {
                    employeeRepo.save(employee);

                    EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
                    responseDTO.setEmpId(employee.getEmpId());
                    responseDTO.setEmpName(employee.getEmpName());
                    responseDTO.setEmpSalary(employee.getEmpSalary());

                    responseDTO.setDeptId(departmentDTO.getDeptId());
                    responseDTO.setDeptName(departmentDTO.getDeptName());
                    responseDTO.setManagerId(departmentDTO.getManagerId());
                    return ResponseEntity.ok(responseDTO);
                });
    }
}
