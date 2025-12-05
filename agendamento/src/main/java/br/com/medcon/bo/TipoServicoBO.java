package br.com.medcon.bo;
import br.com.medcon.dao.TipoServicoDAO;
import br.com.medcon.vo.Especialidade;
import br.com.medcon.vo.TipoServico;
import java.sql.SQLException;
import java.util.List;

import br.com.medcon.bo.exception.NegocioException;
import br.com.medcon.dao.EspecialidadeDAO; 

public class TipoServicoBO {
    private final TipoServicoDAO dao;
    private final EspecialidadeDAO especialidadeDAO; 
        public TipoServicoBO(TipoServicoDAO dao, EspecialidadeDAO especialidadeDAO){
            this.dao = dao;
            this.especialidadeDAO = especialidadeDAO;
        }

        public void salvar(TipoServico servico) throws NegocioException, SQLException {
            //VALIDAÇÃO DE NOME
            if (servico.getNome() == null || servico.getNome().trim().length() < 3) {
                throw new NegocioException("O nome do serviço é obrigatório e deve ter ao menos 3 caracteres.");
            }
            if (servico.getDuracaoMinutos() < 5) {
                throw new NegocioException("A duração do serviço deve ser de no mínimo 5 minutos.");
            }

            // VALIDAÇÃO DA ESPECIALIDADE NECESSÁRIA PARA O SERVIÇO
            Especialidade espNecessaria = servico.getEspecialidadeNecessaria();
            if (espNecessaria == null || espNecessaria.getId() <= 0) {
                throw new NegocioException("O serviço deve ser vinculado a uma Especialidade válida.");
            }

            Especialidade espExistente = especialidadeDAO.buscarPorId(espNecessaria.getId());
            if (espExistente == null) {
                throw new NegocioException("A Especialidade com o ID [" + espNecessaria.getId() + "] não foi encontrada no catálogo. Cadastre a especialidade primeiro.");
            }
            dao.salvar(servico);
        }

        public List<TipoServico> listarTodos() throws SQLException {
            return dao.listarTodos();
        }

        public TipoServico buscarPorId(int id) throws SQLException {
            return dao.buscarPorId(id);
        }
}
