package smoking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;


/**
 * Servlet implementation class SmokingServlet
 */
@WebServlet("/SmokingServlet")
public class SmokingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public static Vector<String> messageList = new Vector<String>();
	
	
	private final static String QUEUE_NAME = "hello";
	
	
	static {
		
		messageList.add("The key is focusing on the positive. Build up the good things in your life and the smoking will go away by itself");
		messageList.add("Health is not everything, but without health, everything else is nothing");
		messageList.add("Pain is temporary. Quitting is forever.");
		
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmokingServlet() {
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
		response.setContentType("text/plain");	    
		PrintWriter out = response.getWriter();	    
		out.println("System Environment:");	    
		
		for (Map.Entry<String, String> envvar : System.getenv().entrySet()) {	        
			out.println(envvar.getKey() + ": " + envvar.getValue());	    
		}
		
		*/
		
		
		
		/*
		
		ConnectionFactory factory = new ConnectionFactory();
	    
	    
	    try {
			factory.setUri("amqp://uMbJP9lZMAbm1:pWKRiwHZa1QV1@172.30.48.107:10001/vc179ad35574b4053a87181798db6ba4a");
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    //factory.setPort(10001);

	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    
	    
	    //channel.q queue.declare('queue_name', passive=True)
	    
	    
	    QueueingConsumer consumer = new QueueingConsumer(channel);    
	    channel.basicConsume(QUEUE_NAME, true, consumer);
	    
	    QueueingConsumer.Delivery delivery = null;
	    
	    
	    
		try {
			
			delivery = consumer.nextDelivery(1000);
		} catch (ShutdownSignalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConsumerCancelledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		
		PrintWriter pw = response.getWriter();
		
		if (delivery != null) {
	    
			String message = new String(delivery.getBody());     
			System.out.println(" [x] Received '" + message + "'");
		
			pw.write("Message: " + message);
		} else {
			
			pw.write("To help distract yourself, try sipping a drink slowly until the craving is over.");
		}
		
		
		
		pw.close();
		
		*/
		
		
		PrintWriter pw = response.getWriter();
		
		if (messageList.size() > 0) {
	    
			String message = new String(messageList.get(messageList.size() - 1));     
			System.out.println(" [x] Received '" + message + "'");
		
			pw.write("Message: " + message);
			
			messageList.remove(messageList.size() - 1);
			
			messageList.add(name);
			
		} else {
			
			pw.write("To help distract yourself, try sipping a drink slowly until the craving is over.");
		}
		
		
		
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
