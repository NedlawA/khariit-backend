package com.khariit.controllers;

import com.khariit.dao.FormRepository;
import com.khariit.models.Form;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


    @SpringBootApplication
    @RestController
    @RequestMapping("api/v_01/words")
    @CrossOrigin
    public class FormController {
        private final FormRepository formRepository;

        public FormController(FormRepository formRepository) {
            this.formRepository = formRepository;
        }


        record AddFormRequest(
                Integer root_id,
                String formVer,
                String engDef
        ) {
        }

        @PostMapping("id/forms")
        public void addForm(@PathVariable("id") Integer id, @RequestBody com.khariit.controllers.FormController.AddFormRequest request) {
            Form form = new Form();
            form.setRootId(request.root_id());
            form.setFormVer(request.formVer());
            form.setEngDef(request.engDef());
            formRepository.save(form);
        }
}
