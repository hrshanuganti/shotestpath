package za.co.in2it.interfaces;

import za.co.in2it.exception.FindPathOperationsException;
import za.co.in2it.helper.Graph;
import za.co.in2it.pojo.Node;

/**
 * Created by rchennupati on 2/10/18.
 */
public interface FindPathOperationsInterface {

    public void intoNode(Node[][] nodeList, char[][] lineArray, Graph g) throws FindPathOperationsException;

    public void connectNodes(Node[][] nodeList, char[][] lineArray, Graph graph) throws FindPathOperationsException;
}
