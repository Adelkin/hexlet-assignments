package exercise;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    // GET /posts — получение списка всех постов
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size())) // Добавляем заголовок с количеством постов
                .body(posts); // Указываем тело ответа
    }

    // GET /posts/{id} — просмотр конкретного поста
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        Optional<Post> post = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        // Если пост найден — возвращаем его, иначе статус 404
        return ResponseEntity.of(post);
    }

    // POST /posts — создание нового поста
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post newPost) {
        posts.add(newPost);

        // Возвращаем статус 201 (Created) с указанием URI нового ресурса
        return ResponseEntity.created(URI.create("/posts/" + newPost.getId()))
                .body(newPost);
    }

    // PUT /posts/{id} — обновление поста
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post updatedPost) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(id)) {
                posts.set(i, updatedPost); // Обновляем пост
                return ResponseEntity.ok(updatedPost); // Возвращаем статус 200
            }
        }

        // Если пост не найден — возвращаем статус 204 (No Content)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
