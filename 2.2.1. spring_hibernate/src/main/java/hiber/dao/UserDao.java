package hiber.dao;

import java.util.List;

import hiber.model.Car;
import hiber.model.User;

public interface UserDao{
	   void add(User user);
	   List<User> listUsers();
	   void add(Car car);
	   User findByCar(int series);
	}