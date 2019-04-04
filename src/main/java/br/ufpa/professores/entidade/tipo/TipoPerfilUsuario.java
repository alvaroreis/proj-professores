/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.entidade.tipo;

public enum TipoPerfilUsuario {

    ADMINISTRADOR('A', "Administrador"),
    INSTITUTO('I', "Instituto"),
    PROFESSOR('P', "Professor");

    private Character valor;

    private String descricao;

    private TipoPerfilUsuario(final Character tipo, final String descricao) {

        this.valor = tipo;
        this.descricao = descricao;
    }

    public static TipoPerfilUsuario obter(final char valor) {

        TipoPerfilUsuario resposta = PROFESSOR;
        final TipoPerfilUsuario[] values = TipoPerfilUsuario.values();
        for (final TipoPerfilUsuario t : values) {
            if (t.getValor() == valor) {
                resposta = t;
                return resposta;
            }
        }
        return resposta;
    }

    public boolean isAdministrador() {

        return this.equals(ADMINISTRADOR);
    }

    public boolean isProfessor() {

        return this.equals(PROFESSOR);
    }

    public boolean isInstituto() {

        return this.equals(INSTITUTO);
    }

    public Character getValor() {

        return this.valor;
    }

    public String getDescricao() {

        return this.descricao;
    }

}
