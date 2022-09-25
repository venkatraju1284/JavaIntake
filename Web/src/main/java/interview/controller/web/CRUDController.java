package interview.controller.web;

import interview.web.TedTalkInformationWebServie;
import interview.model.TedTalkInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/tedtalks/")
public class CRUDController {

    @Autowired
    private TedTalkInformationWebServie tedTalkInformationWebServie;


    @PostMapping("/add")

    public ResponseEntity<TedTalkInformation> addTedTalk(@RequestBody TedTalkInformation userInformation) {

        return ResponseEntity.ok(tedTalkInformationWebServie.addTedTalk(userInformation));

    }

    @PutMapping("/update/{id}")

    public ResponseEntity<TedTalkInformation> updateTedTalk(@PathVariable Long id, @RequestBody TedTalkInformation userInformation) {

        return ResponseEntity.ok(tedTalkInformationWebServie.updateTedTalk(id, userInformation));

    }

    @PutMapping("/remove/{id}")

    public ResponseEntity<String> removeTedTalk(@PathVariable Long id) {

        return ResponseEntity.ok(tedTalkInformationWebServie.removeTedTalk(id));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TedTalkInformation> getTedTalk(@PathVariable Long id) {

        Optional<TedTalkInformation> userInformation = tedTalkInformationWebServie.findTedTalkById(id);
        if (userInformation.isPresent()) {
            return ResponseEntity.ok(userInformation.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/authors/{author}")
    public ResponseEntity<List<TedTalkInformation>> getTedTalksByAuthor(@PathVariable String author) {
        List<TedTalkInformation> tedTalkInformationList = tedTalkInformationWebServie.findTedTalksByAuthor(author);

        return ResponseEntity.ok(tedTalkInformationList);
    }

    @GetMapping("/titles/{title}")
    public ResponseEntity<List<TedTalkInformation>> getTedTalksByTitle(@PathVariable String title) {
        List<TedTalkInformation> tedTalkInformationList = tedTalkInformationWebServie.findTedTalksByTitle(title);

        return ResponseEntity.ok(tedTalkInformationList);
    }

    @GetMapping("/likes")
    public ResponseEntity<List<TedTalkInformation>> getTedTalksByLikes(@RequestParam("from") Long fromNoOfLikes, @RequestParam("to") Long toNoOfLikes) {
        List<TedTalkInformation> tedTalkInformationList = tedTalkInformationWebServie.findTedTalksByLikes(fromNoOfLikes, toNoOfLikes);

        return ResponseEntity.ok(tedTalkInformationList);
    }

    @GetMapping("/views")
    public ResponseEntity<List<TedTalkInformation>> getTedTalksByViews(@RequestParam("from") Long fromNoOfViews, @RequestParam("to") Long toNoOfViews) {
        List<TedTalkInformation> tedTalkInformationList = tedTalkInformationWebServie.findTedTalksByViews(fromNoOfViews, toNoOfViews);

        return ResponseEntity.ok(tedTalkInformationList);
    }
}
