package com.app.VetPetShop.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Doctors")
public class Doctors {
	
	@Id
	private String licenseNo;
	
	@OneToOne
	@JoinColumn(name = "doctorId", referencedColumnName = "userId")
	private Users doctorId;
	
	@Column(nullable = false)
	private String specialization;
	
	@Column(nullable = false)
	private String qualification;
	
	@Column(nullable = false)
	private String clinicAddress;

	public Doctors(String licenseNo, String specialization, String qualification, String clinicAddress) {
		super();
		this.licenseNo = licenseNo;
		this.specialization = specialization;
		this.qualification = qualification;
		this.clinicAddress = clinicAddress;
	}

	public Doctors() {
		super();
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Users getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Users doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	@Override
	public String toString() {
		return "Doctors [licenseNo=" + licenseNo + ", doctorId=" + doctorId + ", specialization=" + specialization
				+ ", qualification=" + qualification + ", clinicAddress=" + clinicAddress + "]";
	}

}
