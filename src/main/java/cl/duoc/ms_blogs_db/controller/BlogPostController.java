package cl.duoc.ms_blogs_db.controller;

import cl.duoc.ms_blogs_db.model.dto.BlogPostDto;
import cl.duoc.ms_blogs_db.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPostDto> getAll() {
        return blogPostService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostDto> getById(@PathVariable Long id) {
        return blogPostService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BlogPostDto create(@RequestBody BlogPostDto dto) {
        return blogPostService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPostDto> update(@PathVariable Long id, @RequestBody BlogPostDto dto) {
        return blogPostService.getById(id)
                .map(existing -> {
                    dto.setId(id);
                    return ResponseEntity.ok(blogPostService.save(dto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (blogPostService.getById(id).isPresent()) {
            blogPostService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
