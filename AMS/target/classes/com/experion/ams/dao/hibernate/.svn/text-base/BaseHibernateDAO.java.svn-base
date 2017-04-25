package com.experion.ams.dao.hibernate;

import java.io.Serializable;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.experion.ams.dao.BaseDAO;


/**
 * @author Aneesh Chandran
 * 
 */
public class BaseHibernateDAO<T> extends HibernateDaoSupport implements
		BaseDAO, Serializable {

	private static final long serialVersionUID = -6499974777212536676L;

	/**
	 * This method will execute the stored procedure in the database. The
	 * procedure name, and its arguments are passed as incoming parameters.
	 */
	@SuppressWarnings("unchecked")
	public void executeProcedure(final String procName,
			final List<String> procArgs) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(final Session session)
					throws HibernateException, SQLException {
				try {
					/*Query query = session
							.createSQLQuery(
									"CALL " + procName + "(:itemNumber)")
							.addEntity(Book.class)
							.setParameter("itemNumber", procArgs.get(0));

					query.executeUpdate();*/
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println("Something went wrong with id ");
					e.printStackTrace();
					throw new RuntimeException(e);
				}
				return null;
			}
		});
	}
}

