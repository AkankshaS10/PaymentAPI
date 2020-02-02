package com.rev.apitest.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.rev.apitest.controller.AccountController;
import com.rev.apitest.controller.UserController;
import com.rev.apitest.repo.AccountRepo;
import com.rev.apitest.repo.UserRepo;

/**
 * @author Akanksha 
 * App start the initializes and starts the jetty server
 */

public class App {

	public static void main(String args[]) {

		System.out.println("Initialization..");
		// load data
		loadData();
		// Start server
		startService();
	}

	
	public static void startService() {
		
		Server server = new Server(8888);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
		//configure all controller 
		servletHolder.setInitParameter("jersey.config.server.provider.classnames",
				AccountController.class.getCanonicalName() + "," + UserController.class.getCanonicalName());
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.destroy();
		}
	}

	public static void loadData() {
		// Load data for account and user
		new AccountRepo();
		new UserRepo();
	}
}
