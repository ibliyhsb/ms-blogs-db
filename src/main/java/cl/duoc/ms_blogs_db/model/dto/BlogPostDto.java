package cl.duoc.ms_blogs_db.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostDto {
    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private String usuarioAutor;
    private String fechaPublicacion;
    private Boolean esPublicado;
    private String imagenUri;
}
