package com.ascii274.practica.bean;

import java.math.BigDecimal;

public enum EnumFeina {	
	Software_Engineer("Software Engineer", BigDecimal.valueOf(45000)),
    Data_Scientist("Data Scientist", BigDecimal.valueOf(47000)),
    QA_Tester("QA Tester", BigDecimal.valueOf(30000)),
    Support_Specialist("Support Specialist", BigDecimal.valueOf(35000)),
    Web_Developer("Web Developer", BigDecimal.valueOf(34000)),
    Web_Administrator("Web Administrator", BigDecimal.valueOf(32000)),
    IT_Technician("IT Technician", BigDecimal.valueOf(36000)),
    UX_Designer("UX Designer", BigDecimal.valueOf(31000)),
    Database_Administrator("Database Administrator", BigDecimal.valueOf(40000)),
    IT_Director("IT Director", BigDecimal.valueOf(67000)),
    Cloud_System_Engineer("Cloud System Engineer", BigDecimal.valueOf(55000));
	
	private String nomTreball;
	private BigDecimal salari;
	
	
	
	EnumFeina(String nomTreball, BigDecimal bigDecimal){
		this.nomTreball = nomTreball;
		this.salari = bigDecimal;
	}


	public String getNomTreball() {
		return nomTreball;
	}


	public void setNomTreball(String nomTreball) {
		this.nomTreball = nomTreball;
	}


	public BigDecimal getSalari() {
		return salari;
	}


	public void setSalari(BigDecimal salari) {
		this.salari = salari;
	}
	
	

}
