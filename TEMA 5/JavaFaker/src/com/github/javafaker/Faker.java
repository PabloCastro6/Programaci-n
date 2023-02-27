package com.github.javafaker;

public class Faker {

		public static void main(String[] args) {
			
			Faker faker = new Faker();
			
			
			String name = faker.name().fullName();
			faker.hipster () .word();
			faker.chuckNorris().fact();
			for (int  i = 0; i < 6; i++) {
				System.out.println(faker.hipster().word());
			}

		}

	}

