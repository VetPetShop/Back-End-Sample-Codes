package com.app.VetPetShop.DTO;

public class NewDoctorDto {
	
	private String licenseNo;
	
	private String specialization;
	
	private String qualification;
	
	private String clinicAddress;
	
	private Long doctorId;

	public NewDoctorDto(String licenseNo, Long doctorId, String specialization, String qualification, String clinicAddress) {
		super();
		this.licenseNo = licenseNo;
		this.doctorId = doctorId;
		this.specialization = specialization;
		this.qualification = qualification;
		this.clinicAddress = clinicAddress;
	}

	public NewDoctorDto() {
		super();
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public String getQualification() {
		return qualification;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	@Override
	public String toString() {
		return "NewDoctorDto [licenseNo=" + licenseNo + ", specialization=" + specialization + ", qualification="
				+ qualification + ", clinicAddress=" + clinicAddress + "]";
	}

}
