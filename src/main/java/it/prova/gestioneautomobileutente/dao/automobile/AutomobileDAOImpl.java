package it.prova.gestioneautomobileutente.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneautomobileutente.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {
	private EntityManager entityManager;

	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	@Override
	public Automobile findOne(Long id) throws Exception {
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		
		input = entityManager.merge(input);			
	}

	@Override
	public void insert(Automobile input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		
		entityManager.persist(input);
	}

	@Override
	public void delete(Automobile input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		
		entityManager.remove(entityManager.merge(input));
	}
	
	@Override
	public List<Automobile> findByExample(Automobile input) throws Exception {
		String findByExample ="select a from Automobile a where 1=1";
		
		if (input.getMarca() != null && !input.getMarca().equals("")) {
            findByExample += " and a.marca = '" + input.getMarca() + "' ";
        }
        if (input.getModello() != null && !input.getModello().equals("")) {
            findByExample += " and a.modello='" + input.getModello() + "' ";
        }

        if (input.getCilindrata() != null && input.getCilindrata()>0) {
            findByExample += " and a.cilindrata ='" + input.getCilindrata() + "' ";
        }

        if (input.getDataImmatricolazione() != null) {
            findByExample += " and a.dataImmatricolazione ='" + input.getDataImmatricolazione() + "' ";
        };

        TypedQuery<Automobile> query = entityManager
                .createQuery(findByExample, Automobile.class);
        return query.getResultList();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
