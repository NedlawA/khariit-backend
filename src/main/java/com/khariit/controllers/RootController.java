package com.khariit.controllers;

import com.khariit.dao.ArRootRepository;
import com.khariit.models.Form;
import com.khariit.models.Root;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@SpringBootApplication
@RestController
@RequestMapping("api/v_01/words")
@CrossOrigin
public class RootController {
    private final ArRootRepository arRootRepository;

    public RootController(ArRootRepository arRootRepository) {
        this.arRootRepository = arRootRepository;
    }

    @GetMapping
    public List<Root> getRoots() {
        return arRootRepository.findAll();
    }

    @GetMapping("/en_letters")
    @ResponseBody
    public Iterable getWordByIdUsingEngRootLetters(@RequestParam String engLetters) {
        return arRootRepository.findByEngLetters(engLetters);
    }

    @GetMapping("/ar_letters")
    @ResponseBody
    public Iterable getWordByIdUsingArRootLetters(@RequestParam String letters) {
        return arRootRepository.findByLetters(letters);
    }

    record AddRootRequest(
            String letters,
            String engLetters
    ) {
    }

    @PostMapping
    public void addRoot(@RequestBody com.khariit.controllers.RootController.AddRootRequest request) {
        Root root = new Root();
        root.setLetters(request.letters());
        root.setEngLetters(request.engLetters());
        arRootRepository.save(root);
    }

    @PutMapping("{rootId}")
    public void updateRoot(@PathVariable("rootId") Integer id, @RequestBody com.khariit.controllers.RootController.AddRootRequest updateRequest) {
        Optional<Root> obj = arRootRepository.findById(id);
        if (obj.isPresent()) {
            Root root = obj.get();
            if (updateRequest.letters != null) {
                root.setLetters(updateRequest.letters());
            }
            if (updateRequest.engLetters !=null) {
                root.setEngLetters(updateRequest.engLetters());
            }
            arRootRepository.save(root);
        }
    }

    @DeleteMapping("{rootId}")
    public void deleteRoot(@PathVariable("rootId") Integer id) {
        arRootRepository.deleteById(id);
    }

}