import java.util.*;

public class Blog {

    List<Post> posts;

    public Blog() {
        posts = new ArrayList<Post>();
    }

    public void adicionarPostagem(Post post) {
        posts.add(post);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<String>();
        for (Post post : posts) {
            String autor = post.getAutor();
            if (!autores.contains(autor)) {
                autores.add(autor);
            }
        }
        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> postsPorCategoria = new TreeMap<String, Integer>();
        for (Post post : posts) {
            String categoria = post.getCategoria();
            postsPorCategoria.put(categoria, postsPorCategoria.getOrDefault(categoria, 0) + 1);
        }
        return postsPorCategoria;
    }
}
