package webapps;

import trabajo.Grafo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GrafosServlet
 */
public class GrafosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Grafo g;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrafosServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.g = new Grafo();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nombreVertice = request.getParameter("nombreVertice");
		if(nombreVertice != null) {
			g.agregarVertice(nombreVertice);
		}
		String aristaA = request.getParameter("aristaA");
		String aristaB = request.getParameter("aristaB");
		if(aristaA != null && aristaB != null) {
			if(request.getParameter("bidir") != null) {
				g.agregarArista(aristaA, aristaB);
			}
			if(request.getParameter("dir") != null) {
				g.agregarAristaDir(aristaA, aristaB);
			}
		}
		
		System.out.print(g.toString());
		response.getWriter().append(g.toString());
		//response.sendRedirect("/Grafos_1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
