package cl.duoc.ms_blogs_db.repository;

import cl.duoc.ms_blogs_db.model.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
