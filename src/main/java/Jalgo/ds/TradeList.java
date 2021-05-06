package dev.toddmartin.Jalgo.ds;

import java.util.List;

public class TradeList {

    class Node {
        Node nextNode;
        Node prevNode;
        double data;
    }

    private int size;
    private Node head;
    private Node tail;

    /**
     * Default constructor.
     */
    public TradeList () {
        Node n = new Node();
        n.nextNode = null;
        n.prevNode = null;
        size = 0;
        head = n;
        tail = n;
    }

    /**
     * Add in a new data point of price to collection.
     * @param price Price that the stock last sold at
     */
    public Node addNode (double price) {
        if (size == 0) {
            head.data = price;
            size++;
            return head;
        } else {
            Node n = new Node();
            n.data = price;
            head.prevNode = n;
            n.nextNode = head;
            head = n;
            if (size == 200) {
                tail = tail.prevNode;
                tail.nextNode = null;
            } else if (size <  200) {
                size++;
            }
            return head;
        }
    }

    public double calculateMovingAverage () {
        if (size == 200) {
            double fiftyMA = 0;
            double twoHundredMA = 0;
            double currentTotal = 0;
            Node currentNode = head;
            for (int i = 0; i < 200; i++) {
                currentTotal = currentTotal + currentNode.data;
                if (i == 50) {
                    fiftyMA = currentTotal / 50;
                }
                if (currentNode.nextNode == null) {
                    break;
                } else {
                    currentNode = currentNode.nextNode;
                }
            }
            twoHundredMA = currentTotal / 200;
            return twoHundredMA - fiftyMA;
        } else {
            double halfMA = 0;
            double fullMA = 0;
            double currentTotal = 0;
            Node currentNode = head;
            for (int i = 0; i < size; i++) {
                currentTotal = currentTotal + currentNode.data;
                if (size > 1) {
                    if (i == (size/2)) {
                        halfMA = currentTotal / (size/2);
                    } 
                }
            }
            fullMA = currentTotal / size;
            return fullMA - halfMA;
        }
    }

    public double getLastPrice () {
        return head.data;
    }

    public int getSize() {
        return size;
    }

}
