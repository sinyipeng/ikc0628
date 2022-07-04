package tw.com.finalproj.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import tw.com.finalproj.service.OrderDetailsService;
import tw.com.finalproj.service.domain.OrderDetailsBean;


@WebServlet(urlPatterns = "/pages/OrderDetailsDisplay.controller")
public class OrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private OrderDetailsService orderDetailsService;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		orderDetailsService = context.getBean("orderDetailsService", OrderDetailsService.class);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		String temp1 = request.getParameter("orderID");
		String prodaction = request.getParameter("prodaction");
		
		// 驗證資料
		// 轉換資料
		Integer ordersID = Integer.parseInt(temp1);
		// 呼叫Model
		OrderDetailsBean bean = new OrderDetailsBean();
		bean.setOrderdetailid(0);
		bean.setOrderid(ordersID);
		System.out.println(bean);
		if(prodaction!=null && prodaction.equals("Select")) {
			System.out.println("有到select裡");
			List<OrderDetailsBean> result = orderDetailsService.selectFK(bean);
			System.out.println("select成功");
			request.setAttribute("select", result);
			System.out.println("[servlet]"+result);
			request.getRequestDispatcher(
					"/pages/OrderDetailsDisplay.jsp").forward(request, response);
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
