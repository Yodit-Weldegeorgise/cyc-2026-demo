package com.learningcenter.demo.mistake1.apidesign.bad;

import com.learningcenter.demo.shared.repository.ParentRepository;
import org.springframework.web.bind.annotation.*;

@RestController("badApiDesignParentController")
@RequestMapping("/demo/bad/parents")
public class ParentController {
    private final ParentRepository parents;
    public ParentController(ParentRepository parents) { this.parents = parents; }
    @GetMapping("/{parentId}/creditBalance")
    public Integer getCreditsByParentId(@PathVariable Long parentId) {
        return parents.findById(parentId).orElseThrow().getCreditBalance();
    }
}
