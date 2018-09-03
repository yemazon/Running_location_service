package demo.service.impl;

import demo.domain.InformationRepository;
import demo.domain.RunningInformation;
import demo.domain.RunningInformationDTO;
import demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    private InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository){
        this.informationRepository = informationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation (List<RunningInformation> runningInformation){
        for(RunningInformation rx : runningInformation){
            rx.setHeartRate((int) (Math.random() * 140 + 60));
        }
        return informationRepository.save(runningInformation);
    }

    @Override
    public void deleteByUserId(int UserId){
        informationRepository.deleteByUserId(UserId);


    }

    @Override
    public Page<RunningInformationDTO> findAll(Pageable pageable){
        Sort sort = new Sort(Sort.Direction.DESC, "heartRate");
        List<RunningInformation> runningInformations = informationRepository.findAll(sort);
        List<RunningInformationDTO> runningInformationDTOS = new ArrayList<RunningInformationDTO>();
        for (RunningInformation ri : runningInformations){
            runningInformationDTOS.add(new RunningInformationDTO(ri));
        }
        Page<RunningInformationDTO> runningInformationDTOr = new PageImpl<RunningInformationDTO>(runningInformationDTOS,pageable,runningInformationDTOS.size());
        return runningInformationDTOr;
    }
}