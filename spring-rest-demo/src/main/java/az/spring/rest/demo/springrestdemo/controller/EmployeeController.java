package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.rest.model.DTO.EmployeeDTO;
import az.spring.rest.demo.springrestdemo.rest.model.response.EmployeeResponse;
import az.spring.rest.demo.springrestdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public EmployeeResponse getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employee-id}")
    public EmployeeDTO getEmployee(@PathVariable("employee-id") long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/search")
    public EmployeeResponse getEmployeeByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {

        return employeeService.getEmployeeByNameAndSurname(name, surname);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.insert(employeeDTO);
    }

    @PutMapping("/{id}")
    public void updateAll(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") long id) {
        employeeService.update(employeeDTO, id);

    }

    @PatchMapping("/{id}")
    public void updateSome(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") long id) {
        employeeService.updateSome(employeeDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")long id){
        employeeService.delete(id);
    }
}