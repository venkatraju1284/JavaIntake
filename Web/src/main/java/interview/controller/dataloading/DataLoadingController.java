package interview.controller.dataloading;

import interview.service.DataLoadService;
import interview.util.CSVUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DataLoadingController {

    @Autowired
    private DataLoadService dataLoadService;
    @PostMapping(path = "/load", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity loadCSV(@RequestPart MultipartFile file) {
        String message = "";

        if (CSVUtil.hasCSVFormat(file)) {
            try {
                dataLoadService.persistData(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();

                return ResponseEntity.ok().build();
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}