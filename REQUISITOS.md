# Requisitos do Projeto MEDCON e Critérios de Avaliação

Este documento lista os requisitos formais e os critérios de avaliação adotados para o projeto de Programação Orientada a Objetos (POO).

## 1. Requisitos Técnicos e de Estrutura

1.  **Estrutura em Camadas:** O projeto deve ser estruturado nas camadas **View, BO (Business Object), VO (Value Object) e DAO (Data Access Object)**, garantindo o Princípio da Responsabilidade Única.
2.  **Banco de Dados (CRUD):** Uso obrigatório de Banco de Dados para operações de **insert, update, delete e select**. A conexão será feita via JDBC.
    *   **Recomendação de SGBD:** SQLite ou H2 Database, por serem baseados em arquivo e de fácil configuração em projetos acadêmicos.
3.  **Gestão de Código:** O projeto deve estar no **GitHub**, sendo acompanhado desde o início, para que os *commits* de cada integrante possam ser verificados.
4.  **Interface (Opcional):** O uso de interface mobile ou web é opcional. A implementação atual utiliza uma interface de **console** (`System.out.println` e `Scanner`).

## 2. Requisitos de Orientação a Objetos (OO)

Os seguintes conceitos de POO devem ser aplicados e serão critérios de avaliação:

1.  **Classes e Encapsulamento:** Uso adequado de classes e o uso de atributos `private` com Getters/Setters (Encapsulamento).
2.  **Classes Abstratas:** Utilização de classes abstratas (Exemplo: `Pessoa`).
3.  **Herança:** Aplicação do conceito de herança (Exemplo: `Paciente` *extends* `Pessoa`, `Medico` *extends* `Pessoa`).
4.  **Interfaces:** Uso de interfaces (Exemplo: `IBaseDAO<T>`).
5.  **Polimorfismo:** Uso de Polimorfismo, que pode ser demonstrado na sobrescrita do método `toString()` em classes como `Paciente` e `Médico`, ou na camada DAO onde diferentes DAOs implementam a mesma interface de formas distintas.
6.  **Construtores:** Uso de construtores.

## 3. Requisitos de Lógica e Qualidade

1.  **Collections:** Uso obrigatório de Collections. Exemplos de uso incluem: `List<Consulta>` para histórico do paciente e `Queue<Paciente>` para a fila de espera do posto. Uma `PriorityQueue` pode ser usada se houver prioridade (idosos/gestantes).
2.  **Exceções Customizadas:** Uso de exceções. Devem ser criadas **exceções próprias** (Ex: `AgendamentoIndisponivelException`, `PacienteJaCadastradoException`) e tratadas corretamente na `View` através de *try-catch*.
3.  **Regras de Negócio (BO):** Implementação de regras de negócio complexas na camada BO (Exemplo: "Um médico não pode ter duas consultas no mesmo horário").
    *   **Validação de Agendamento:** O BO deve verificar se o paciente já possui consulta agendada naquele dia e se há vaga na fila antes de salvar no DAO.
    *   **Limite de Marcação:** O sistema deve restringir marcações a um período de até 30 dias.
4.  **Testes Unitários:** Uso de Testes Unitários automatizados:
    *   Para cada regra de negócio (BO).
    *   Para o acesso ao Banco de Dados (DAO).
