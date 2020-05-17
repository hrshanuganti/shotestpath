package za.co.in2it.controller;

import za.co.in2it.helper.FileOperations;
import za.co.in2it.helper.FindPathOperations;
import za.co.in2it.helper.Graph;
import za.co.in2it.interfaces.FileReaderInterface;
import za.co.in2it.pojo.Node;

import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rchennupati on 1/26/18.
 */
public class FindPath {
    private static final Logger logger = Logger.getLogger(FindPath.class.getName());

	public static void main(String[] args) {

        logger.info("za.co.in2it.controller.FindPath.main() start");
        try {

            FileReaderInterface fileReader = new FileOperations();
            Stream<String> lines = fileReader.readFile("map.txt");
            List<String> lineList = lines.collect(Collectors.toList());

            int rowCount = (int) lineList.stream().count();
            int columnCount = (int) Pattern.compile("\\s").splitAsStream(lineList.stream().findAny().get()).count();

            char[][] lineArray = new char[rowCount][columnCount];
            IntStream.range(0, rowCount).forEach(idx -> intoArray(lineList.get(idx), lineArray, idx));

            Graph graph = new Graph();
            Node[][] nodes = new Node[rowCount][columnCount];

            printMap(lineArray, null, false);

            FindPathOperations operations = new FindPathOperations();
            operations.intoNode(nodes, lineArray, graph);
            operations.connectNodes(nodes, lineArray, graph);

            graph.searchPath2(graph.rootNode, graph.destinationNode);
            printMap(lineArray, nodes, true);

            logger.info("za.co.in2it.controller.FindPath.main() end");

        } catch (Exception e){

        }
    }

    private static void intoArray(String line, char[][] lineArray, int index){

        logger.info("za.co.in2it.controller.FindPath.intoArray() start");

        char[] columnArray = Pattern.compile("\\s").splitAsStream(line).collect(Collectors.joining()).toCharArray();
        lineArray[index] = columnArray;

        logger.info("za.co.in2it.controller.FindPath.intoArray() end");
    }

    private static void printMap(char[][] lineArray, Node[][] nodes, boolean isResultMap){

        logger.info("za.co.in2it.controller.FindPath.printMap() start");

        IntStream.range(0, lineArray.length).forEach(rowIdx -> {
            IntStream.range(0, lineArray[0].length).forEach(colIdx -> {
                if(isResultMap){
                    System.out.print(nodes[rowIdx][colIdx].label);
                }else {
                    System.out.print(lineArray[rowIdx][colIdx]);
                }
            });
            System.out.println();
        });
        logger.info("za.co.in2it.controller.FindPath.printMap() end");
    }
}
