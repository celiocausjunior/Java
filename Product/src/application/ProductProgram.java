package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class ProductProgram {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Product # " + i + " data: ");
			System.out.println("Common, used or import (c/u/i)? ");
			char resp = sc.next().charAt(0);

			if (resp == 'i') {
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Price: ");
				double price = sc.nextDouble();
				System.out.println("Customs fee: ");
				Double customsFee = sc.nextDouble();

				Product p1 = new ImportedProduct(name, price, customsFee);
				list.add(p1);
			}

			if (resp == 'u') {
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Price: ");
				double price = sc.nextDouble();
				System.out.println("Manufacture date: ");
				Date manufactureDate = sdf.parse(sc.next());

				Product p1 = new UsedProduct(name, price, manufactureDate);
				list.add(p1);

			}

			if (resp == 'c') {
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Price: ");
				double price = sc.nextDouble();

				Product p1 = new Product(name, price);
				list.add(p1);
			}

		}

		System.out.println("PRICE TAGS: ");
		for (Product p : list) {
			System.out.println(p.getName() + "  $  " + String.format("%.2f", p.getPrice()));

		}

		sc.close();

	}

}
