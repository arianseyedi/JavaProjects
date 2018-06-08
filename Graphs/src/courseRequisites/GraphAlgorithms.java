/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package courseRequisites;

import java.util.Set;
import java.util.HashSet;

/**
 * A collection of graph algorithms.
 */
public class GraphAlgorithms {

	/**
	 * Performs depth-first search of the unknown portion of Graph g starting at
	 * Vertex u.
	 *
	 * @param g
	 *            Graph instance
	 * @param u
	 *            Vertex of graph g that will be the source of the search
	 * @param known
	 *            is a set of previously discovered vertices
	 * @param forest
	 *            is a map from nonroot vertex to its discovery edge in DFS forest
	 *
	 *            As an outcome, this method adds newly discovered vertices
	 *            (including u) to the known set, and adds discovery graph edges to
	 *            the forest.
	 */
	public static <V, E> void DFS(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
		known.add(u); // u has been discovered
		for (Edge<E> e : g.outgoingEdges(u)) { // for every outgoing edge from u
			Vertex<V> v = g.opposite(u, e);
			if (!known.contains(v)) {
				forest.put(v, e); // e is the tree edge that discovered v
				DFS(g, v, known, forest); // recursively explore from v
			}
		}
	}

	/**
	 * Performs DFS for the entire graph and returns the DFS forest as a map.
	 *
	 * @return map such that each nonroot vertex v is mapped to its discovery edge
	 *         (vertices that are roots of a DFS trees in the forest are not
	 *         included in the map).
	 */
	public static <V, E> Map<Vertex<V>, Edge<E>> DFSComplete(Graph<V, E> g) {
		Set<Vertex<V>> known = new HashSet<>();
		Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
		for (Vertex<V> u : g.vertices())
			if (!known.contains(u))
				DFS(g, u, known, forest); // (re)start the DFS process at u
		return forest;
	}
}