package com.example.demo.security;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author david
 */
@Component
public class CustomFilterInterceptor extends GenericFilterBean {

    @Autowired
    private StudentRepository studentRepository;

    public CustomFilterInterceptor() {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) sr;
        String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader != null) {
            String base64Credentials = authHeader.substring("Basic".length()).trim();
            if (base64Credentials.replace("r ", "").matches("[a-zA-z0-9]{8}-[a-zA-z0-9]{4}-[a-zA-z0-9]{4}-[a-zA-z0-9]{4}-[a-zA-z0-9]{12}")) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) sr1;
                httpServletResponse.sendError(401, "check basic Authentication Header");
            } else {
                String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
                final String[] values = credentials.split(":", 2);
                Student isUserFoundStudent = studentRepository.findByEmailOrUsername(values[0], values[0]);
                if (isUserFoundStudent != null && (values[1].equals(isUserFoundStudent.getPassword()))) {
                    //validate client
                    fc.doFilter(sr, sr1);
                } else {
                    HttpServletResponse httpServletResponse = (HttpServletResponse) sr1;
                    httpServletResponse.sendError(401, "check basic Authentication Header");
                }
            }
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) sr1;
            httpServletResponse.sendError(401, "check basic Authentication Header");
        }

    }

}
