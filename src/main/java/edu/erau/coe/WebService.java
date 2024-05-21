package edu.erau.coe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * WebService, answering the question, if the given integer x is even or odd.
 * Remember: requestURI = contextPath + servletPath + pathInfo
 * - contextPath is basically the name of the WAR when it's deployed
 * - servletPath is declared as "/evenORodd" below.
 */
@WebServlet(value = "/evenORodd", name = "EO")
public class WebService extends HttpServlet {
    private final Logger logger = LogManager.getLogger(WebService.class);

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        try {
            final int x = Integer.parseInt(req.getParameter("x"));
            resp.setHeader("Content-Type", "text/html; charset=UTF-8");
            resp.getWriter().printf("%d is %s", x, (x % 2) == 0 ? "even" : "odd");
            resp.setStatus(HttpServletResponse.SC_OK);
            logger.info("That went well.");
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(ex.toString());
        }
    }
}