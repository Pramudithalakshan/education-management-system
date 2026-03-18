package org.dreamdevzone.controller;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.model.dto.ParentDto;
import org.dreamdevzone.service.ParentService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/parent")
public class ParentController {
    private final ParentService service;
    @PostMapping
    public void add(@RequestBody ParentDto parentDto) {
        service.add(parentDto);
    }
    @GetMapping("/getAll")
    public List<ParentDto> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }
    @GetMapping("/{id}")
    public ParentDto get(@PathVariable Integer id) {
        return service.get(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    @PutMapping("/{id}")
    public ParentDto update( @PathVariable Integer id, @RequestBody ParentDto parentDto) {
        return service.update(id,parentDto);
    }
}
