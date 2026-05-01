package practice2;

 class Employee2 {
		private String name;
		private Integer id;
		private Double salary;
		
		public Employee2(String name, Integer id, Double salary) {
			super();
			this.name = name;
			this.id = id;
			this.salary = salary;
		}

		public Employee2() {}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}
		
		
}
