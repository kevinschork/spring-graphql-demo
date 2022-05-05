package de.kschork.springgraphqldemo.persistence;

import de.kschork.springgraphqldemo.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    List<Student> findByName(@Param("name") String name);

}
