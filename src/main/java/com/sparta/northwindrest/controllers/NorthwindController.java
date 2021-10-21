//package com.sparta.northwindrest.controllers;
//
//import com.sparta.northwindrest.entities.*;
//import com.sparta.northwindrest.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class NorthwindController {
//
//    private final ProductRepository productRepository;
//    private final CustomersRepository customersRepository;
//    private final EmployeeRepository employeeRepository;
//    private final ShipperRepository shipperRepository;
//    private final SupplierRepository supplierRepository;
//    private final OrderRepository orderRepository;
//
//    @Autowired
//    public NorthwindController(ProductRepository productRepository, CustomersRepository customersRepository, EmployeeRepository employeeRepository, ShipperRepository shipperRepository, SupplierRepository supplierRepository, OrderRepository orderRepository) {
//        this.productRepository = productRepository;
//        this.customersRepository = customersRepository;
//        this.employeeRepository = employeeRepository;
//        this.shipperRepository = shipperRepository;
//        this.supplierRepository = supplierRepository;
//        this.orderRepository = orderRepository;
//    }
//
//    // ----------------------------------Products---------------------------------------------
//
//    @GetMapping("/products")
//    public List<ProductEntity> getAllProducts(){
//        return productRepository.findAll();
//    }
//
//    @GetMapping("/products/{id}")
//    public Optional<ProductEntity> getProductsById(@PathVariable Integer id){
//        return productRepository.findById(id); // Exact matching
//    }
//
//    // ----------------------------------Customers---------------------------------------------
//
//    @GetMapping("/customers")
//    @ResponseBody
//    public List<CustomersEntity> getAllCustomers(@RequestParam(required = false) String name){
//        if (name == null){
//            return customersRepository.findAll();
//        }
//        return customersRepository.findAll()
//                .stream()
//                .filter(customersEntity -> customersEntity.getContactName().contains(name))
//                .toList();
//    }
//
//    // -----------------------------------Employee--------------------------------------------
//
//    @GetMapping("/employees")
//    @ResponseBody
//    public List<EmployeeEntity> getAllEmployees(){
//        return employeeRepository.findAll();
//    }
//
////    @GetMapping("/employees")
////    @ResponseBody
////    public List<EmployeeEntity> getEmployeesFirstNameAndCountry(@RequestParam(required = false) String firstName,
////                                                                  @RequestParam(required = false) String country){
////
////        if (firstName == null || country == null){
////            return employeeRepository.findAll();
////        }
////        return employeeRepository.findAll()
////                .stream()
////                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName) &&
////                        employeeEntity.getCountry().equals(country))
////                .toList();
////    }
//
//    // -----------------------------------Suppliers---------------------------------------------
//
//    @GetMapping("/suppliers")
//    @ResponseBody
//    public List<SupplierEntity> getAllSuppliers(){
//        return supplierRepository.findAll();
//    }
//
//    // -----------------------------------Shipper---------------------------------------------
//
//    @GetMapping("/shippers")
//    @ResponseBody
//    public List<ShipperEntity> getAllShippers(){
//        return shipperRepository.findAll();
//    }
//
//    // -----------------------------------Orders---------------------------------------------
//
//    @GetMapping("/orders")
//    @ResponseBody
//    public List<OrderEntity> getAllOrders(){
//        return orderRepository.findAll();
//    }
//
//    @GetMapping("/orders/{id}")
//    @ResponseBody
//    public Optional<OrderEntity> getOrderById(@PathVariable Integer id){
//        return orderRepository.findById(id);
//    }
//}
