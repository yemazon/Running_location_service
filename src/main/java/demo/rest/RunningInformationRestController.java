package demo.rest;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationDTO;
import demo.service.InformationService;
import demo.service.impl.InformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationRestController {

    private InformationService informationServiceImpl;

    @Autowired
    public RunningInformationRestController(InformationServiceImpl informationServiceImpl) {
        this.informationServiceImpl = informationServiceImpl;
    }


    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformations) {

        informationServiceImpl.saveRunningInformation(runningInformations);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformationDTO> findAll(@PageableDefault(value = 2) Pageable pageable) {
        return this.informationServiceImpl.findAll(pageable);
    }


    @RequestMapping(value = "/runningInfo/{UserId}", method = RequestMethod.DELETE)
    public void deleteByUserId(@PathVariable int UserId) {
        informationServiceImpl.deleteByUserId(UserId);
    }
}