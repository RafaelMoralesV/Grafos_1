package webapps;

import trabajo.GrafoPesado;
import trabajo.MST;
import trabajo.Vertice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GrafosServlet
 */
public class GrafosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GrafoPesado g;
	String inicio;
	String destino;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrafosServlet() {
        super();
        // TODO Auto-generated constructor stub
        g = new GrafoPesado();
        inicio = null;
        destino = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = (String) request.getParameter("command");
		
		if(command != null) {
			String output = null;
			if(command.contentEquals("matrizAdy")) {
				output = g.toString() + "\n" + (g.esConexo()?"La matriz es conexa" : "La matriz NO es conexa");
			}
			if(command.contentEquals("matrizPeso")){
				output = g.toStringPeso() + "\n" + (g.esConexo()?"La matriz es conexa" : "La matriz NO es conexa");
			}
			if(command.contentEquals("hamiltoneano")) {
				StringBuilder sc = new StringBuilder();
				List<Vertice> camino = g.caminoHamiltoneano();
				
				for(Vertice v : camino) {
					sc.append(v.getNombre() + " ->\t");
				}
				try{
					sc.replace(sc.lastIndexOf(" "), sc.lastIndexOf(">") + 1, "");
					sc.append("\nCAMINO HAMILTONEANO");
					output = sc.toString();
				}
				catch(StringIndexOutOfBoundsException oobe) {
					output = "No existe camino Hamiltoneano";
				}
			}
			if(command.contentEquals("dijkstra")) {
				if(inicio != null && destino != null) {
					System.out.print(inicio + "\t" + destino);
					StringBuilder sc = new StringBuilder();
					List<Vertice> camino = g.dijkstra(inicio, destino);
					for(Vertice v : camino) {
						sc.append(v.getNombre() + " ->\t");
					}
					try{
						sc.replace(sc.lastIndexOf(" "), sc.lastIndexOf(">") + 1, "");
						sc.append("\nCAMINO MAS CORTO");
						output = sc.toString();
					}
					catch(StringIndexOutOfBoundsException oobe) {
						output = "No existe un camino";
					}
					catch(ArrayIndexOutOfBoundsException ioobe) {
						output = "No existe un camino";
					}
				}
			}
			if(command.contentEquals("MST")) {
				int n = g.sizeVertices();
				MST mst = new MST(n);
				output = g.toStringPeso(mst.generarSubGrafo(g.generarMatrizPesos()));
			}
			
			if(output != null) {
				response.setContentType("text/plain");
				response.getWriter().write(output);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreVertice = request.getParameter("nombreVertice");
		if(nombreVertice != null) {
			g.agregarVertice(nombreVertice);
		}
		String aristaA = request.getParameter("aristaA");
		String aristaB = request.getParameter("aristaB");
		String sPeso = request.getParameter("peso");
		
		float peso;
		if(sPeso == null) {
			peso = 1;
		}else {
			try {
				peso = Float.parseFloat(sPeso);
			}
			catch(NumberFormatException nfe) {
				peso = 1;
			}
		}
		
		if(aristaA != null && aristaB != null) {
			if(request.getParameter("bidir") != null) {
				g.agregarArista(aristaA, aristaB, peso);
			}
			if(request.getParameter("dir") != null) {
				g.agregarAristaDir(aristaA, aristaB, peso);
			}
		}
		
		String conf = request.getParameter("post");
		if(conf != null) {
			String _inicio = request.getParameter("inicio");
			String _destino = request.getParameter("fin");
			if(_inicio != null && _destino != null) {
				this.inicio = _inicio;
				this.destino = _destino;
			}
		}
		
		response.sendRedirect("/Grafos_1");
		//doGet(request, response);
	}

}
