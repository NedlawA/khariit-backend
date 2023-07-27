package com.khariit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v_01/words")
public class Main {
    private final ArRootRepository arRootRepository;

    public Main(ArRootRepository arRootRepository) {
        this.arRootRepository = arRootRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Root> getRoots() {
        return arRootRepository.findAll();
    }

    record AddRootRequest(
            String letters,
            String engLetters
    ) {
    }

    @PostMapping
    public void addRoot(@RequestBody AddRootRequest request) {
        Root root = new Root();
        root.setLetters(request.letters());
        root.setEngLetters(request.engLetters());
        arRootRepository.save(root);
    }

    @PutMapping("{rootId}")
    public void updateRoot(@PathVariable("rootId") Integer id, @RequestBody AddRootRequest updateRequest) {
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
