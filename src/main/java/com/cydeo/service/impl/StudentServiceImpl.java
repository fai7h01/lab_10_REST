package com.cydeo.service.impl;

import com.cydeo.dto.StudentDTO;
import com.cydeo.entity.Student;
import com.cydeo.exception.AlreadyExistsException;
import com.cydeo.exception.NotFoundException;
import com.cydeo.repository.AddressRepository;
import com.cydeo.repository.ParentRepository;
import com.cydeo.repository.StudentRepository;
import com.cydeo.repository.TeacherRepository;
import com.cydeo.service.StudentService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final ParentRepository parentRepository;
    private final TeacherRepository teacherRepository;
    private final MapperUtil mapperUtil;

    public StudentServiceImpl(StudentRepository studentRepository,
                              AddressRepository addressRepository,
                              ParentRepository parentRepository,
                              TeacherRepository teacherRepository,
                              MapperUtil mapperUtil) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
        this.parentRepository = parentRepository;
        this.teacherRepository = teacherRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository
                .findAll()
                .stream()
                .map(student -> mapperUtil.convert(student, new StudentDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        Optional<Student> foundStudent = studentRepository.findByUsername(studentDTO.getUsername());

        if (foundStudent.isPresent()) {
            throw new AlreadyExistsException("Student already exists!");
        }

        addressRepository.findByAddressNo(studentDTO.getAddressNo())
                .orElseThrow(() -> new NotFoundException("Address not found!"));
        parentRepository.findByUsername(studentDTO.getParent())
                .orElseThrow(() -> new NotFoundException("Parent not found!"));
        teacherRepository.findByUsername(studentDTO.getTeacher())
                .orElseThrow(() -> new NotFoundException("Teacher not found!"));

        Student studentToSave = mapperUtil.convert(studentDTO, new Student());
        Student savedStudent = studentRepository.save(studentToSave);

        return mapperUtil.convert(savedStudent, new StudentDTO());

    }

}
