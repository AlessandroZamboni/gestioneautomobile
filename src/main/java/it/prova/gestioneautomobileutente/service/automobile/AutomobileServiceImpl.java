package it.prova.gestioneautomobileutente.service.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneautomobileutente.dao.automobile.AutomobileDAO;
import it.prova.gestioneautomobileutente.model.Automobile;
import it.prova.gestioneautomobileutente.web.listener.LocalEntityManagerFactoryListener;

public class AutomobileServiceImpl implements AutomobileService {
	private AutomobileDAO automobileDao;
	
	@Override
	public void setAutomobileDao(AutomobileDAO automobileDao) {
		this.automobileDao = automobileDao;		
	}

	@Override
	public List<Automobile> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Automobile caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Automobile input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo � come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);
			

			// eseguo quello che realmente devo fare
			automobileDao.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void inserisciNuovo(Automobile input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}		
	}

	@Override
	public void rimuovi(Automobile input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			// questo � come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			input = entityManager.merge(input);

			automobileDao.delete(input);				


			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}
	
	@Override
	public List<Automobile> findByExample(Automobile input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		
		
		try {
			// questo � come il MyConnection.getConnection()

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			input = entityManager.merge(input);

			return automobileDao.findByExample(input);				


		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

}
