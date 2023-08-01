package com.khariit.controllers;

import com.khariit.dao.ArRootRepository;
import com.khariit.dao.FormRepository;
import com.khariit.models.Form;
import com.khariit.models.Root;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@SpringBootApplication
    @RestController
    @RequestMapping("api/v_01/words")
    @CrossOrigin
    public class FormController {
        private final FormRepository formRepository;
        private final ArRootRepository arRootRepository;

        public FormController(FormRepository formRepository, ArRootRepository arRootRepository) {
            this.formRepository = formRepository;
            this.arRootRepository = arRootRepository;
        }


        record AddFormRequest(
                Integer root_id,
                String formVer,
                String engDef
        ) {
        }

        @PostMapping("{id}/forms")
        public void addForm(@PathVariable("id") Integer id, @RequestBody com.khariit.controllers.FormController.AddFormRequest request) {
            Optional<Root> obj = arRootRepository.findById(id);
            Root root = obj.get();

            Form form = new Form();
            form.setRoot(root);
            form.setFormVer(request.formVer());
            form.setEngDef(request.engDef());
            formRepository.save(form);
        }
}
