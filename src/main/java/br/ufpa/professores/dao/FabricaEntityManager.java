package br.ufpa.professores.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fabio
 */
public class FabricaEntityManager {

    private static EntityManagerFactory fabrica;

    private FabricaEntityManager() {

    }

    public static EntityManagerFactory obterFabrica() {

        if (FabricaEntityManager.fabrica == null) {
            return FabricaEntityManager.obterFabrica("ProfessoresPU");
        } else {
            return FabricaEntityManager.fabrica;
        }
    }

    public static EntityManagerFactory obterFabrica(final String unidadePersistencia) {

        if ((FabricaEntityManager.fabrica != null) && FabricaEntityManager.fabrica.isOpen()) {
            FabricaEntityManager.fabrica.close();
        }
        FabricaEntityManager.fabrica = Persistence.createEntityManagerFactory(unidadePersistencia);
        return FabricaEntityManager.fabrica;
    }

}
