## Many to One e Many to Many

### Usando JPQL - evitando consultras lentas com countQuery
- Join Fetch muitos-para-um (todos)
- Join Fetch muitos-para-muitos (todos)
- Join Fetch muitos-para-um (paginada)

Repository Class:
```java
    //Buscar todos
    @Query(value = "SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> searchAll();
    
    ////Busca Paginada
    @Query(value = "SELECT e FROM Employee e JOIN FETCH e.department",
        countQuery = "SELECT COUNT(e) FROM Employee e JOIN e.department")
    Page<Employee> searchAllPageable(Pageable pageable);
```

Controller Class:
```java
    //Buscar todos
	@GetMapping
	public List<Employee> findAll() {
		return employeeRepository.searchAll();
	}

	//Busca Paginada
	@GetMapping
	public Page<Employee> findAll(Pageable pageable) {
		return employeeRepository.searchAllPageable(pageable);
	}
```