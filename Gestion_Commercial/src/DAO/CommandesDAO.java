package DAO;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Commandes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see DAO.Commandes
 * @author MyEclipse Persistence Tools
 */

public class CommandesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CommandesDAO.class);
	// property constants
	public static final String CLIENT = "client";
	public static final String CODE_L = "codeL";
	public static final String QTE_CMD = "qteCmd";

	public void save(Commandes transientInstance) {
		log.debug("saving Commandes instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Commandes persistentInstance) {
		log.debug("deleting Commandes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Commandes findById(java.lang.Integer id) {
		log.debug("getting Commandes instance with id: " + id);
		try {
			Commandes instance = (Commandes) getSession().get("DAO.Commandes",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Commandes instance) {
		log.debug("finding Commandes instance by example");
		try {
			List results = getSession().createCriteria("DAO.Commandes").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Commandes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Commandes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClient(Object client) {
		return findByProperty(CLIENT, client);
	}

	public List findByCodeL(Object codeL) {
		return findByProperty(CODE_L, codeL);
	}

	public List findByQteCmd(Object qteCmd) {
		return findByProperty(QTE_CMD, qteCmd);
	}

	public List findAll() {
		log.debug("finding all Commandes instances");
		try {
			String queryString = "from Commandes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commandes merge(Commandes detachedInstance) {
		log.debug("merging Commandes instance");
		try {
			Commandes result = (Commandes) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commandes instance) {
		log.debug("attaching dirty Commandes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commandes instance) {
		log.debug("attaching clean Commandes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}