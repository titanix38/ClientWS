package com.m2i.formation.jsf.test;

import java.rmi.RemoteException;
import java.util.Locale.Category;

import javax.xml.rpc.ServiceException;

import com.m2i.formation.jsf.managedBeans.BookBean;
import com.m2i.formation.jsf.managedBeans.HelloService;
import com.m2i.formation.jsf.managedBeans.HelloServiceServiceLocator;

public abstract class Test
{
	public static void main(String[] args) throws ServiceException, RemoteException
	{
		HelloService service = new HelloServiceServiceLocator().getHelloService();
		System.out.println(service.getHello());
		int cat;
		String strCat = "";

		BookBean bb = new BookBean();
		bb = service.getBook(1, "Perceval fait du WS", 9.99, 0);
		System.out.println("Titre = " + bb.getTitle());
		System.out.println("Prix = " + bb.getPrice());
		cat = bb.getCategory();

		switch (cat)
			{
			case 0:
				strCat = com.m2i.formation.jsf.test.Category.Book.toString();
				break;

			case 1:
				strCat = com.m2i.formation.jsf.test.Category.CD.toString();
				break;
			case 2:
				strCat = com.m2i.formation.jsf.test.Category.DVD.toString();
				break;
			default:
			}
		System.out.println(strCat);
	}

}
