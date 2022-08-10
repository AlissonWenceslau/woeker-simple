package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//Associação
	private Department department;// 1 - 1
	private List<HourContract> contracts = new ArrayList<>(); // 1 - *
	
	public Worker() {
		
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContracts(HourContract contract) {
		this.contracts.add(contract);
		
	}
	
	public void removeContracts(HourContract contract) {
		this.contracts.remove(contract);
		
	}
	/*
	 * No método abaixo, income, temos o pricípio de delegação, pois o método totalValue(); é da classe HourContract
	 * que tem por sua responsabilidade de fazer a soma dos contratos.
	 */
	public double income(int year, int month) {
		double sum = this.baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for(HourContract c: this.contracts) {		
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);			
			if(year == c_year && month == c_month) {
				sum+= c.totalValue();
			}
		}
		
		return sum;
	}
}
