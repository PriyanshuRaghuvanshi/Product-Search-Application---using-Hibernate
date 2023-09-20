package com.nagarro.tshirt;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nagarro.enums.Color;
import com.nagarro.enums.Gender;
import com.nagarro.enums.Size;

@Entity
@Table(name = "tshirt")
public class Tshirt {

	@Id
	private String id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Color colour;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private Size size;

	private double rating;
	private double price;

	private String availability;

	public Tshirt() {
	}

	public Tshirt(String ID, String Name, Color Colour, Gender Gender, Size Size, float Price, float Rating,
			String Availability) {

		this.id = ID;
		this.name = Name;
		this.colour = Colour;
		this.gender = Gender;
		this.size = Size;
		this.price = Price;
		this.rating = Rating;

	}

	public String getID() {
		return id;
	}

	public void setID(String ID) {
		this.id = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color color) {
		this.colour = color;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size Size) {
		this.size = Size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double d) {
		this.rating = d;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String Availability) {
		this.availability = Availability;
	}

	@Override
	public String toString() {
		return "Tshirt [id=" + id + ", name=" + name + ", colour=" + colour + ", gender=" + gender + ", size=" + size
				+ ", rating=" + rating + ", price=" + price + ", availability=" + availability + "]";
	}

}