package com.learningcenter.demo.mistake1.apidesign.good;

import com.learningcenter.demo.shared.repository.ParentRepository;
import org.springframework.web.bind.annotation.*;

@RestController("goodApiDesignParentController")
@RequestMapping("/demo/good/parents")
public class ParentController {
    private final ParentRepository parents;
    public ParentController(ParentRepository parents) { this.parents = parents; }
    @GetMapping("/{parentId}/credit-balance")
    public Integer getCreditsByParentId(@PathVariable Long parentId) {
        return parents.findById(parentId).orElseThrow().getCreditBalance();
    }
}
