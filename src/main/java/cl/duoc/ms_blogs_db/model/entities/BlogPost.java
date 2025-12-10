package cl.duoc.ms_blogs_db.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "formulario_blog", indexes = {@Index(name = "idx_usuario_autor", columnList = "usuario_autor")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    @Column(length = 2000)
    private String contenido;

    @Column(name = "usuario_autor")
    private String usuarioAutor;

    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;

    @Column(name = "es_publicado")
    private Boolean esPublicado = false;

    @Column(name = "imagen_uri")
    private String imagenUri;
}
