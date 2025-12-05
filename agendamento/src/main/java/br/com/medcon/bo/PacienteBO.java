package br.com.medcon.bo;
import br.com.medcon.dao.PacienteDAO;
import br.com.medcon.bo.exception.NegocioException;
import br.com.medcon.vo.Paciente;
import java.sql.SQLException;
import java.time.LocalDate;

public class PacienteBO {
    private final PacienteDAO dao;
    public PacienteBO(PacienteDAO dao) { //injeção manual, a view tem que passar um dao válido
        this.dao = dao;
    }   
    public void salvar(Paciente paciente) throws NegocioException, SQLException {
        // VALIDAÇÕES DE NOME
        if (paciente.getNome() == null || paciente.getNome().trim().length() < 3) {
            throw new NegocioException("Nome do paciente digitado está vazio, ou muito pequeno.");
        }
        // VALIDAÇÕES DE DATA DE NASCIMENTO
        if (paciente.getDataNascimento() == null) {
            throw new NegocioException("A data de nascimento é obrigatória.");
        }
        if (paciente.getDataNascimento().isAfter(LocalDate.now())) {
            throw new NegocioException("Data de nascimento inválida: O paciente não pode ter nascido no futuro.");
        }
        //VALIDAÇÕES DE CPF
        String cpfLimpo = limparNumero(paciente.getCpf());
        if (paciente.getCpf() == null || paciente.getCpf().trim().isEmpty()) {
            throw new NegocioException("O CPF é obrigatório.");
        }
        if (cpfLimpo.length() != 11) {
            throw new NegocioException("CPF inválido: Deve conter exatamente 11 dígitos numéricos.");
        }
        paciente.setCpf(cpfLimpo);
        Paciente cpfExistente = dao.buscarPorCpf(cpfLimpo);
        if (cpfExistente != null) {
            throw new NegocioException("Já existe um paciente cadastrado com este CPF.");
        }
        //VALIDAÇÃO DE TELEFONE
        String foneLimpo = limparNumero(paciente.getTelefone());
        if (foneLimpo.length() < 10 || foneLimpo.length() > 11) {
            throw new NegocioException("Telefone inválido: Deve conter DDD + Número (10 ou 11 dígitos).");
        }
        paciente.setTelefone(foneLimpo);
        //VALIDAÇÃO DE ENDEREÇO
        if (paciente.getEndereco() == null || paciente.getEndereco().trim().length() < 5) {
            throw new NegocioException("Endereço muito curto. Informe logradouro e número.");
        }
        //VALIDAÇÃO DE CARTAO DO SUS
        String susLimpo = limparNumero(paciente.getCartaoSus());
        if (susLimpo.length() < 11) {
             throw new NegocioException("Número do Cartão SUS inválido.");
        }
        paciente.setCartaoSus(susLimpo);
        dao.salvar(paciente);
    }

    private String limparNumero(String texto) {
            if (texto == null) return "";
            return texto.replaceAll("\\D", "");
    }

    public Paciente buscarPorCpf(String cpf) throws SQLException {
        String cpfLimpo = limparNumero(cpf);
        return dao.buscarPorCpf(cpfLimpo);
    }
}
