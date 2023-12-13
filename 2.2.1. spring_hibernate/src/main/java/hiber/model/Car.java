package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car{
	
	@Id
	@Column(name = "series")
	private Integer series;
	
	@Column(name = "model")
	private String model;

	@OneToOne(mappedBy = "car")
	private User user;

	public Car() {}

	public Car(int series, String model) {
		this.series = series;
		this.model = model;
	}

	public Integer getSeries() {
		return series;
	}


	public void setSeries(Integer series) {
		this.series = series;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Car [series=" + series + ", model=" + model + "]";
	}
	
	

}
