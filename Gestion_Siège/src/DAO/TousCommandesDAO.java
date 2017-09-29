package DAO;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TousCommandes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see DAO.TousCommandes
 * @author MyEclipse Persistence Tools
 */

public class TousCommandesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TousCommandesDAO.class);
	// property constants
	public static final String CODE_CMD = "codeCmd";
	public static final String CLIENT = "client";
	public static final String CODE_L = "codeL";
	public static final String QTE_CMD = "qteCmd";

	public void save(TousCommandes transientInstance) {
		log.debug("saving TousCommandes instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TousCommandes persistentInstance) {
		log.debug("deleting TousCommandes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TousCommandes findById(java.lang.Integer id) {
		log.debug("getting TousCommandes instance with id: " + id);
		try {
			TousCommandes instance = (TousCommandes) getSession().get(
					"DAO.TousCommandes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TousCommandes instance) {
		log.debug("finding TousCommandes instance by example");
		try {
			List results = getSession().createCriteria("DAO.TousCommandes")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TousCommandes instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TousCommandes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCodeCmd(Object codeCmd) {
		return findByProperty(CODE_CMD, codeCmd);
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
		log.debug("finding all TousCommandes instances");
		try {
			String queryString = "from TousCommandes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TousCommandes merge(TousCommandes detachedInstance) {
		log.debug("merging TousCommandes instance");
		try {
			TousCommandes result = (TousCommandes) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TousCommandes instance) {
		log.debug("attaching dirty TousCommandes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TousCommandes instance) {
		log.debug("attaching clean TousCommandes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}