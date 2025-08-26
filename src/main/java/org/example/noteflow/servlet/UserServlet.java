package org.example.noteflow.web;

import org.example.noteflow.dao.UserDao;
import org.example.noteflow.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserDao dao;

    @Override
    public void init() {
        dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            User user = dao.findById(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(req, resp);
        } else {
            List<User> users = dao.findAll();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/WEB-INF/user-list.jsp").forward(req, resp);
        }
    }
}
