package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.ICustomerService;
import com.codegym.service.no_jdbc.CustomerManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerManage customerService = new CustomerManage();
    ICustomerService customerDAO = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                showViewForm(request, response);
                break;
            case "creat":
                showCreatForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "remove":
                showRemoveForm(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/creat.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/view.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerView = customerDAO.findById(id);
        request.setAttribute("customerView", customerView);
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDAO.findById(id);
        request.setAttribute("customerEdit", customer);
        requestDispatcher.forward(request, response);
    }

    private void showRemoveForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/remove.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerRemove = customerDAO.findById(id);
        request.setAttribute("customerRemove", customerRemove);
        requestDispatcher.forward(request, response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        List<Customer> customers = customerDAO.findAll();
        request.setAttribute("customers", customers);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat":
                try {
                    creatCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "remove":
                try {
                    removeCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void creatCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        customerDAO.add(new Customer(name, email, address));
        response.sendRedirect("/customers");
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerDAO.update(customer);
        response.sendRedirect("/customers");
    }

    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerDAO.delete(id);
        response.sendRedirect("/customers");
    }

}
