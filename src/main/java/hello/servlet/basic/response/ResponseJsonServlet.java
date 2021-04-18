package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type : application/Json
        response.setContentType("application/Json");
        response.setCharacterEncoding("UTF-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("han");
        helloData.setAge(28);

        //{"username" : han, "age" : 28}
        String result = objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);
    }
}
