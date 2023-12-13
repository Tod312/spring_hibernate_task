package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.graph.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

	@Override
	public void add(Car car) {
		sessionFactory.getCurrentSession().save(car);
	}

	@Override
	public User findByCar(int series) {
		String hql = "select u from User u inner join u.car c where c.series = :series";
//		Query query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
//		query.setParameter("series", series);
		User user = sessionFactory.getCurrentSession().createQuery(hql, User.class)
				.setParameter("series", series)
				.getSingleResult();
		return user;
	}


}
