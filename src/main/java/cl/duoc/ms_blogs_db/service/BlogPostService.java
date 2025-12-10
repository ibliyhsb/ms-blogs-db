package cl.duoc.ms_blogs_db.service;

import cl.duoc.ms_blogs_db.model.dto.BlogPostDto;
import cl.duoc.ms_blogs_db.model.entities.BlogPost;
import cl.duoc.ms_blogs_db.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPostDto> getAll() {
        return blogPostRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<BlogPostDto> getById(Long id) {
        return blogPostRepository.findById(id).map(this::toDto);
    }

    public BlogPostDto save(BlogPostDto dto) {
        BlogPost entity = toEntity(dto);
        BlogPost saved = blogPostRepository.save(entity);
        return toDto(saved);
    }

    public void delete(Long id) {
        blogPostRepository.deleteById(id);
    }

    private BlogPostDto toDto(BlogPost entity) {
        return new BlogPostDto(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescripcion(),
                entity.getContenido(),
                entity.getUsuarioAutor(),
                entity.getFechaPublicacion(),
                entity.getEsPublicado(),
                entity.getImagenUri()
        );
    }

    private BlogPost toEntity(BlogPostDto dto) {
        BlogPost entity = new BlogPost();
        entity.setId(dto.getId());
        entity.setTitulo(dto.getTitulo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setContenido(dto.getContenido());
        entity.setUsuarioAutor(dto.getUsuarioAutor());
        entity.setFechaPublicacion(dto.getFechaPublicacion());
        entity.setEsPublicado(dto.getEsPublicado());
        entity.setImagenUri(dto.getImagenUri());
        return entity;
    }
}
