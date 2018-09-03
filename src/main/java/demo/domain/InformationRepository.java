package demo.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InformationRepository extends JpaRepository<RunningInformation, Long> {


    List<RunningInformation> findAll();

    List<RunningInformation> findAll(Sort sort);
    @Transactional
    void deleteByUserId(@Param("UserId") int runningId);
}