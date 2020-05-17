package za.co.in2it.helper;

import za.co.in2it.pojo.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * Created by rchennupati on 1/26/18.
 */
public class Graph {
    private static final Logger logger = Logger.getLogger(Graph.class.getName());

	public Node rootNode;
	public Node destinationNode;
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public int[][] adjMatrix;
	int size;

	public void setRootNode(Node n) {
		this.rootNode = n;
	}

	public Node getRootNode() {
		return this.rootNode;
	}

	public void setDestinationNode(Node n) {
		this.destinationNode = n;
	}

	public Node getDestinationNode() {
		return this.destinationNode;
	}

	public void addNode(Node n) {
		nodes.add(n);
	}

	public void connectNode(Node start, Node end) {
        logger.info("za.co.in2it.helper.FindPathOperations.connectNode() start");

        if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;

        logger.info("za.co.in2it.helper.FindPathOperations.connectNode() end");
	}

	private Node getUnvisitedChildNode(Node n) {

        logger.info("za.co.in2it.helper.FindPathOperations.getUnvisitedChildNode() start");
		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1 && ((Node) nodes.get(j)).visited == false) {
				return (Node) nodes.get(j);
			}
			j++;
		}
        logger.info("za.co.in2it.helper.FindPathOperations.getUnvisitedChildNode() before return");
		return null;
	}

    public void searchPath2(Node source, Node destination) {
        logger.info("za.co.in2it.helper.FindPathOperations.searchPath2() start");

		Queue<Node> q = new LinkedList<Node>();
		Map<Node,Node> prevNodeMap = new HashMap<Node, Node>();
			Node currentNode = source;
		currentNode.visited = true;
		currentNode.label = 'S';
		q.add(currentNode);
		while (!q.isEmpty()) {
		   currentNode = q.remove();
		   if(currentNode == destination){
			   destination.label='E';
			   break;
		   }else{
			   Node child = null;
				while ((child = getUnvisitedChildNode(currentNode)) != null) {
					child.visited = true;
					child.label = '"';
					q.add(child);
					prevNodeMap.put(child,currentNode);
				}

		   }

		}
		if (currentNode != destination) {
			System.out.println("no destination node exist");
		}

		List<Node> direction = new LinkedList<Node>();
			Node node = destination;
		while (node!=null) {
			node.label = '*';
			direction.add(node);
			node = prevNodeMap.get(node);
		}
		Collections.reverse(direction);
		source.label='S';
		destination.label='E';
		clearNodes();

        logger.info("za.co.in2it.helper.FindPathOperations.searchPath2() end");
	}


	private void clearNodes() {
        logger.info("za.co.in2it.helper.FindPathOperations.clearNodes() start");

        int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
        logger.info("za.co.in2it.helper.FindPathOperations.clearNodes() end");
	}
}
