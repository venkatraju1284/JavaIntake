package interview.util;

import interview.model.TedTalkInformation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVUtil {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "title", "author", "date", "views", "likes", "link" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<TedTalkInformation> csvToDb(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<TedTalkInformation> tedTalkInformationList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            Long id = new Long(0);
            for (CSVRecord csvRecord : csvRecords) {
                enrich(tedTalkInformationList, csvRecord);
            }

            return tedTalkInformationList;
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private static void enrich(List<TedTalkInformation> tedTalkInformationList, CSVRecord csvRecord) throws ParseException {
        SimpleDateFormat sm = new SimpleDateFormat("MM/dd/yyyy");

        try {
            Date strDate = sm.parse(csvRecord.get("date"));
            TedTalkInformation tedTalkInformation = new TedTalkInformation(
                    csvRecord.get("title"),
                    csvRecord.get("author"),
                    Long.valueOf(csvRecord.get("views")),
                    Long.valueOf(csvRecord.get("likes")),
                    csvRecord.get("link"),
                    strDate
            );

            tedTalkInformationList.add(tedTalkInformation);
        } catch (Exception e) {
            // to nothing for now
        }
    }
}

