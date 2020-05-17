package za.co.in2it.helper;

import za.co.in2it.exception.FindPathOperationsException;
import za.co.in2it.interfaces.FindPathOperationsInterface;
import za.co.in2it.pojo.Node;

import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * Created by rchennupati on 2/11/18.
 */
public class FindPathOperations implements FindPathOperationsInterface {
    private static final Logger logger = Logger.getLogger(FindPathOperations.class.getName());

    @Override
    public void intoNode(Node[][] nodeList, char[][] lineArray, Graph graph) throws FindPathOperationsException {

        logger.info("za.co.in2it.helper.FindPathOperations.intoNode() start");
        try{

            IntStream.range(0, lineArray.length).forEach(rowIdx -> {
                IntStream.range(0, lineArray[rowIdx].length).forEach(colIdx -> {
                    nodeList[rowIdx][colIdx] = new Node(lineArray[rowIdx][colIdx]);
                    if ((nodeList[rowIdx][colIdx]).label == 'S') {
                        graph.setRootNode(nodeList[rowIdx][colIdx]);
                        (nodeList[rowIdx][colIdx]).label = '.';
                    }
                    if ((nodeList[rowIdx][colIdx]).label == 'E') {
                        graph.setDestinationNode(nodeList[rowIdx][colIdx]);
                        (nodeList[rowIdx][colIdx]).label = '.';
                    }
                    graph.addNode(nodeList[rowIdx][colIdx]);
                });
            });

            logger.info("za.co.in2it.helper.FindPathOperations.intoNode() end");
        } catch(Exception e){
            throw new FindPathOperationsException(e.getMessage());
        }

    }

    @Override
    public void connectNodes(Node[][] nodeList, char[][] lineArray, Graph graph) throws FindPathOperationsException {

        logger.info("za.co.in2it.helper.FindPathOperations.connectNodes() start");
        try{

            IntStream.range(0, lineArray.length).forEach(rowIdx -> {
                IntStream.range(0, lineArray[0].length).forEach(colIdx -> {
                    if ((nodeList[rowIdx][colIdx]).label == '.') {
                        if ((rowIdx + 1) < lineArray.length && (nodeList[rowIdx + 1][colIdx]).label == '.') {
                            graph.connectNode(nodeList[rowIdx][colIdx], nodeList[rowIdx + 1][colIdx]);
                        }
                        if ((colIdx + 1) < lineArray[rowIdx].length && (nodeList[rowIdx][colIdx + 1]).label == '.') {
                            graph.connectNode(nodeList[rowIdx][colIdx], nodeList[rowIdx][colIdx + 1]);
                        }
                        graph.addNode(nodeList[rowIdx][colIdx]);
                    }
                });
                System.out.println();
            });

            logger.info("za.co.in2it.helper.FindPathOperations.connectNodes() end");
        } catch(Exception e){
            throw new FindPathOperationsException(e.getMessage());
        }
    }
}
