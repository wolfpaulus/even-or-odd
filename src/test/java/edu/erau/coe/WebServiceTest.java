package edu.erau.coe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.verify;


class WebServiceTest {

    @Test
    void doGet() throws Exception {
        PrintWriter pw = new PrintWriter(new StringWriter());
        pw.print("3 is odd");

        HttpServletRequest req = niceMock(HttpServletRequest.class);
        expect(req.getParameter("x")).andReturn("3");

        HttpServletResponse res = niceMock(HttpServletResponse.class);
        expect(res.getWriter()).andReturn(pw);

        replay(req, res);
        new WebService().doGet(req, res);
        verify(req, res);
    }
}