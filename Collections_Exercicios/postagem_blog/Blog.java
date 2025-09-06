import java.util.*;

public class Blog {

    private List<Post> posts;

    public Blog() {
        posts = new ArrayList<Post>();
    }

    public void adicionarPostagem(Post post) {
        for (Post p : posts) {
            if (p.getTitulo().equals(post.getTitulo()) && p.getAutor().equals(post.getAutor())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<Autor>();
        for (Post post : posts) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> postsPorCategoria = new TreeMap<Categorias, Integer>();
        for (Post post : posts) {
            Categorias categoria = post.getCategoria();
            postsPorCategoria.put(categoria, postsPorCategoria.getOrDefault(categoria, 0) + 1);
        }
        return postsPorCategoria;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsDoAutor = new TreeSet<Post>();
        for (Post post : posts) {
            if (post.getAutor().equals(autor)) {
                postsDoAutor.add(post);
            }
        }
        return postsDoAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsNaCategoria = new TreeSet<Post>();
        for (Post post : posts) {
            if (post.getCategoria().equals(categoria)) {
                postsNaCategoria.add(post);
            }
        }
        return postsNaCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> postsPorCategoria = new TreeMap<Categorias, Set<Post>>();
        for (Post post : posts) {
            Categorias categoria = post.getCategoria();
            postsPorCategoria.putIfAbsent(categoria, new TreeSet<Post>());
            postsPorCategoria.get(categoria).add(post);
        }
        return postsPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> postsPorAutor = new TreeMap<Autor, Set<Post>>();
        for (Post post : posts) {
            Autor autor = post.getAutor();
            postsPorAutor.putIfAbsent(autor, new TreeSet<Post>());
            postsPorAutor.get(autor).add(post);
        }
        return postsPorAutor;
    }
}
