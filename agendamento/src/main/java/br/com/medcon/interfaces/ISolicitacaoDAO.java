package br.com.medcon.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.medcon.vo.Solicitacao;

public interface ISolicitacaoDAO {
    void salvar(Solicitacao solicitacao) throws SQLException;

    void atualizar(Solicitacao solicitacao) throws SQLException;

    void deletar(int id) throws SQLException;

    Solicitacao buscarPorId(int id) throws SQLException;

    List<Solicitacao> buscarTodos() throws SQLException;

    List<Solicitacao> listarPendentesPorPrioridade(int codigo) throws SQLException;
}
