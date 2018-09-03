package demo.service;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InformationService {

    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation);

    void deleteByUserId(int UserId);

    Page<RunningInformationDTO> findAll(Pageable pageable);
}
