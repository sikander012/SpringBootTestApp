package in.nareshit.raghu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "sid")
	private Integer stdId;

	@Column(name = "sname")
	private String stdName;

	@Column(name = "scourse")
	private String stdCourse;

	@Column(name = "sfee")
	private Double stdFee;

	@Column(name = "sdiscount")
	private Double stdDiscount;

	@Column(name = "sgst")
	private Double stdGst;

	public Student(Integer stdId, String stdName, String stdCourse, Double stdFee, Double stdDiscount, Double stdGst) {
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdCourse = stdCourse;
		this.stdFee = stdFee;
		this.stdDiscount = stdDiscount;
		this.stdGst = stdGst;
	}

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdCourse() {
		return stdCourse;
	}

	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}

	public Double getStdFee() {
		return stdFee;
	}

	public void setStdFee(Double stdFee) {
		this.stdFee = stdFee;
	}

	public Double getStdDiscount() {
		return stdDiscount;
	}

	public void setStdDiscount(Double stdDiscount) {
		this.stdDiscount = stdDiscount;
	}

	public Double getStdGst() {
		return stdGst;
	}

	public void setStdGst(Double stdGst) {
		this.stdGst = stdGst;
	}
	

}
