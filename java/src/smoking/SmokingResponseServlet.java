package smoking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

//import com.rabbitmq.client.MessageProperties;


/**
 * Servlet implementation class SmokingResponseServlet
 */
@WebServlet("/SmokingResponseServlet")
public class SmokingResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static String QUEUE_NAME = "hello";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmokingResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
			
		
		/*
		
		ConnectionFactory factory = new ConnectionFactory();    
		//factory.setHost("localhost");    
		//factory.setHost("172.30.48.107");
	    //factory.setPort(10001);
		try {
			factory.setUri("amqp://uMbJP9lZMAbm1:pWKRiwHZa1QV1@172.30.48.107:10001/vc179ad35574b4053a87181798db6ba4a");
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Connection connection = factory.newConnection();    
		Channel channel = connection.createChannel();    
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);   
		
		
		
		String message = name;    
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());    
		//channel.basicPublish( "", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		
		System.out.println(" [x] Sent '" + message + "'");        
		
		channel.close();    
		connection.close();
		
		PrintWriter pw = response.getWriter();
		pw.write("Your message has been sent");
		pw.close();
		
		
		*/
		
		
		SmokingServlet.messageList.add(name);
		
		PrintWriter pw = response.getWriter();
		pw.write("Your message has been sent");
		pw.close();
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

