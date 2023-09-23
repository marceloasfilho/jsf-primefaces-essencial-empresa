package com.github.marceloasfilho.cursojsfeprimefacesessencial.util;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import javax.inject.Inject;
import java.io.Serial;
import java.io.Serializable;

public class TransactionalInterceptor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction trx = entityManager.getTransaction();
        boolean criador = false;

        try {
            if (!trx.isActive()) {
                // truque para fazer rollback no que já passou
                // (senão, um futuro commit confirmaria até mesmo operações sem
                // transação)
                trx.begin();
                trx.rollback();

                // Inicia a transação
                trx.begin();

                criador = true;
            }

            return context.proceed();
        } catch (Exception e) {
            if (trx != null && criador) {
                trx.rollback();
            }

            throw e;
        } finally {
            if (trx != null && trx.isActive() && criador) {
                trx.commit();
            }
        }
    }
}
