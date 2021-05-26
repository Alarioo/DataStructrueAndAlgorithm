package C04.BidirLinkedList;

import C03.LinkedList.Node;

public class Node2Demo {
    public static void main(String[] args) {
        BidirLinkedList bll=new BidirLinkedList();
        bll.addorder(new Node2(1,"a",null,null));
        bll.addorder(new Node2(3,"c",null,null));
        bll.addorder(new Node2(4,"d",null,null));
        bll.addorder(new Node2(2,"b",null,null));
        bll.reverseShow();
        bll.show();
        bll.update(new Node2(2,"bb",null,null));
        bll.reverseShow();
        bll.show();
        bll.delete(3);
        bll.reverseShow();
        bll.show();
    }
}
