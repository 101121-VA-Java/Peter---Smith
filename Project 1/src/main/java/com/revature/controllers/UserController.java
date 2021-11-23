package com.revature.controllers;

import java.util.List;

import com.revature.models.ErsUsers;
import com.revature.services.AuthService;
import com.revature.services.ErsUserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {

	private static ErsUserService us = new ErsUserService();
	private static AuthService as = new AuthService();

	/*
	 * getUsers will be used to handle several behaviors at /Users using query params
	 * 		- /users
	 * 			- return all employees
	 * 		- /users?id=[value]
	 * 			- return employee with a specific id
	 */
	public static void getEmployees(Context ctx) {

		String token = ctx.header("Authorization");
		
		if(!as.checkPermission(token, "Manager")) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		
		// retrieving query param for id or null if it doesn't exist
		String id1 = ctx.queryParam("id");


		// if a query param for id has been passed in
		if (id1 != null) {
			int id = Integer.parseInt(id1);
			ErsUsers e = us.getUserById(id);

			if (e != null) {
				ctx.json(e);
				ctx.status(HttpCode.OK);
			} else {
				ctx.status(HttpCode.NOT_FOUND);
			}
	
		} else {
			List<ErsUsers> employees = us.getUsers();

			ctx.json(employees);
			// implicitely Javalin sets the status code to 200
			ctx.status(HttpCode.OK);
		}
	}
	
}
