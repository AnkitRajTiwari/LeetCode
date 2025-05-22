class Node{
    
    String url;
    Node next;
    Node prev;
    public Node(String url){
        this.url = url;
        next = null;
        prev = null;
    }
}
class BrowserHistory {
     Node root = null;
    public BrowserHistory(String homepage) {
        root = new Node(homepage);
    }
    
    public void visit(String url) {
        Node curr = root;
        root.next = new Node(url);
        root = root.next;
        root.prev = curr;
        
    }
    
    public String back(int steps) {
        while(root.prev!=null && steps-- >0){
            root = root.prev;
        }
        return root.url;
    }
    
    public String forward(int steps) {
         while(root.next!=null & steps-- >0){
            root = root.next;
        }
        return root.url;
    }
}