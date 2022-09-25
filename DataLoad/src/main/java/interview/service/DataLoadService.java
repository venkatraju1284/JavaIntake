package interview.service;

import interview.model.TedTalkInformation;
import interview.repository.TedTalkInformationRepository;
import interview.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DataLoadService {

    @Autowired
    private TedTalkInformationRepository tedTalkInformationRepository;

    public void persistData(MultipartFile file) {

        try{
            List<TedTalkInformation> tedTalkInformations = CSVUtil.csvToDb(file.getInputStream());
            tedTalkInformationRepository.saveAll(tedTalkInformations);
        } catch (IOException exception) {
            throw new RuntimeException("fail to read csv data: " + exception.getMessage());
        }


    }
}

