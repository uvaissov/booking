package kz.astana.uvaissov.booking.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContentController {
	@Autowired
    private ServletContext servletContext;
	
	@RequestMapping(value = "/image-employees", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImageAsResponseEntity() throws IOException {
	    HttpHeaders headers = new HttpHeaders();
	    System.out.println(servletContext.getRealPath("/"));
	    InputStream in = servletContext.getResourceAsStream("/WEB-INF/resources/static/images/beer.jpg");
	    byte[] media = IOUtils.toByteArray(in);
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	     
	    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	}
}
