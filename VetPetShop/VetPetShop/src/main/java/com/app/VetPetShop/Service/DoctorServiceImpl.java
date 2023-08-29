//package com.app.VetPetShop.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
//import com.app.VetPetShop.DTO.NewDoctorDto;
//import com.app.VetPetShop.DTO.UserRequestDto;
//import com.app.VetPetShop.Pojos.Doctors;
//import com.app.VetPetShop.Pojos.UserType;
//import com.app.VetPetShop.Pojos.Users;
//import com.app.VetPetShop.Repositories.DoctorRepository;
//import com.app.VetPetShop.Repositories.UserRepository;
//
//public class DoctorServiceImpl implements DoctorService {
//	
//	@Autowired
//	private ModelMapper mapper;
//	
//	@Autowired
//	private DoctorRepository doctorRepo;
//	
//	@Autowired
//	private UserRepository userRepo;
//
//	@Override
//	public List<UserRequestDto> getAllDoctors(UserType typeId) {
//		List<Users> doctors = userRepo.findAllByUserTypeId(typeId).orElseThrow(()->new EntityNotFoundException("No Doctors available !!"));
//		return doctors.stream().map(user -> mapper.map(user, UserRequestDto.class)).collect(Collectors.toList());
//	}
//
//	@Override
//	public Doctors getDoctorDetails(Users doctorId) {
//		Doctors doctor = doctorRepo.findByDoctorId(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor not found !!"));
//		return doctor;
//	}
//
//	@Override
//	public String updateDoctorDetails(NewDoctorDto doctr, Users doctorId) {
//		Doctors doctor = doctorRepo.findByDoctorId(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor not found !!"));
//		doctor.setClinicAddress(doctr.getClinicAddress());
//		doctor.setQualification(doctr.getQualification());
//		doctor.setSpecialization(doctr.getSpecialization());
//		doctorRepo.save(doctor);
//		return "Doctor details updated successfully...";
//	}
//
//	@Override
//	public String registerDoctor(NewDoctorDto doctr) {
//		Doctors doctor = mapper.map(doctr, Doctors.class);
//		doctorRepo.save(doctor);
//		return "Doctor registered successfully...";
//	}
//
//	@Override
//	public String deleteDoctor(Users doctorId) {
//		Doctors doctor = doctorRepo.findByDoctorId(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor not found !!"));
//		doctorRepo.delete(doctor);
//		return "Doctor Deleted Successfully...";
//	}
//
//}
