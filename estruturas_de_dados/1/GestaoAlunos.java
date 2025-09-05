import java.util.ArrayList;

public class GestaoAlunos {
    private ArrayList<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public boolean excluirAluno(String nome) {
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            alunos.remove(aluno);
            return true;
        }
        return false;
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos está vazia.");
        }else {
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println(nome + " encontrado! ");
                return aluno;
            }
        }
        System.out.println(nome + " não encontrado.");
        return null;
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adicionará três alunos.
        System.out.println("Adicionando Humberto, Doisberto e Tresberto");
        gestao.adicionarAluno(new Aluno("Humberto", 16));
        gestao.adicionarAluno(new Aluno("Doisberto", 15));
        gestao.adicionarAluno(new Aluno("Tresberto", 14));

        // Exibirá a lista de alunos.
        gestao.listarAlunos();

        // Buscará por um aluno.
        gestao.buscarAluno("Doisberto");

        // Excluirá um aluno.
        gestao.excluirAluno("Tresberto");
        System.out.println("Tresberto expulso!");

        //Tentará excluir um aluno inexistente e buscará outro aluno.
        if(!gestao.excluirAluno("Quatroberto")){
            System.out.println("Quatroberto não matriculado!");
        }
        gestao.buscarAluno("Humberto");
    }
}
