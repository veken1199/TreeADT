package assignment3;


import java.util.ArrayList;


class iterator{
	
	int pointer=-1;
	ArrayList<Position> list = new ArrayList<Position>();
	public iterator(ArrayList<Position> list){
		this.list=list;
	}
	public Position getAtRank(int x){
		this.pointer=x;
		Position p = (Position)this.list.get(x);
		return p;
	}
	
	public Position next(){
		this.pointer=pointer+1;
		Position p = (Position)this.list.get(pointer);
		return p;
		
	}
	
	public Position previous(){
		this.pointer=pointer-1;
		Position p = (Position)this.list.get(pointer);
		return p;
	}
	
}
class node {
	 private String value;
	 
	 public node(){
		 this.value= " ";
	 }
	 public void set(String vl){
		 this.value=vl;
	 }
	 
	 public String  getValue(){
		 return this.value;
	 }
	 }

//class Position
class Position{
	private node n = new node();  //variable of type node
	private String id ;   //variable of type String to hold the name of the position
	
	
	//constructor
	public Position(String value, String id){
		this.id=id;
		n.set(value);
		
	}
	
	
	//another constructor that only take string
	public Position (String value){
		n.set(value);
	}
	
	
	public String getElement(){
		return n.getValue();
	}
	
	public void setID(String str){
		this.id=str;
	}
	
	public void setValue(String vl){
		this.n.set(vl);
	}
	
	public Boolean equals(Position p){
		if(this.id.equals(p.id))
			return true;
		else
			return false;
	}
	
	//method to return the id
	public String getID(){
		return this.id;
	}
	
	public String toString(){
		return this.id + " ";
	}
}

//class nodeList that will contain a list of nodes 
class nodeList{
	ArrayList<Position>  list =  new ArrayList<Position>();
	int size =0;
	iterator iteratorObj = new iterator(list);
	//constructor
	public void add(Position p){
		list.add(p);
	}
	
	public int sizeList(){
		return list.size();
	}
	
	
	
}

//class that represents the nodes in the tree
class treeNode{
	private treeNode left;
	private treeNode right;
	private treeNode parent;
	private Position element;
	
	public treeNode(){
		left=null;
		right=null;	
		parent=null;
		element=null;
	}
	
	public treeNode(Position p){
		this.element=p;
	}
	public Position Parent(){
		return this.parent.element;
	}
	
	public void setL(treeNode x){
		this.left=x.left();
	}
	
	public void setR(treeNode x){
		this.right=x.right();
	}
	
	public void setP(treeNode p){
		this.parent=p.parent();
	}
	
	//this method to clone a treeNode
	public  void Clone(treeNode x){
		
		
			
		this.element= new Position("ss");
		this.getEl().setID(x.getEl().getID());
		this.getEl().setValue(x.getEl().getElement());
		
	
		
	}
	
	
	//method to add left child
	public void  addLeftChild(treeNode node){
	if(this.left==null){
		this.left=node;
		}
	}
	//method to add right child
	public void addRightChild(treeNode node){
	if(this.right==null){
		this.right=node;
		
		}
	}
	public void addParent(treeNode Parent){
		this.parent=Parent;
	}
	
	//method to get left child
	public treeNode left(){
		treeNode clone = left;
		return clone;
	}
	
	public treeNode right(){
		treeNode clone = right;
		return clone;
	}
	
	public treeNode parent(){
		return this.parent;
	}
	
	public void left(treeNode p){
		this.left=p;
	}
	public void right(treeNode p){
		this.right=p;
	}
	public void parent(treeNode p){
		this.parent=p;
	}
	public void SetElement(Position p){
		this.element=p;
	}
	public Position getEl(){
		return this.element;
	}
}


//tree class
class Tree{
	static 
		int cc=0;
	
	private treeNode head;
	nodeList nodeList= new nodeList();
	ArrayList<treeNode> treeList = new ArrayList<treeNode>();
	//adding head of the tree
	
	public Tree(treeNode head){
		this.head = head;
		treeList.add(head);
		nodeList.add(head.getEl());
	}
	
	//constructor
	public Tree(treeNode left, treeNode right, treeNode parent, Position element){
		head.left(left);
		head.right(right);
		head.parent(null);
		head.SetElement(element);
		
		
	
	}
	public void addLeft(treeNode Parent, treeNode leftChild){
		Parent.addLeftChild(leftChild);
		treeList.add(leftChild);
		leftChild.addParent(Parent);
		nodeList.add(leftChild.getEl());
		
	}
	
	public void addRight(treeNode Parent, treeNode RightChild){
		Parent.addRightChild(RightChild);
		treeList.add(RightChild);
		RightChild.addParent(Parent);
		nodeList.add(RightChild.getEl());
	}
	
	//method to return the treeNode that has the Position p
	private treeNode FindtreeNode(Position p){
		treeNode x=null; 
		for(int i = 0; i<treeList.size();i++){
			if(treeList.get(i).getEl().equals(p)){
				x=treeList.get(i);
				break;
			}
		}
		return x;
		
	}
	
	//method to return the position 
	public Position root(){
		return head.getEl();
		
	}
	
	//method to return iterator of the position p
	public Position[] Children(Position p){
		
		treeNode par=this.FindtreeNode(p);
		Position [] childrenList =  new Position[2];
		if(par.left()!=null)
			childrenList[0]=par.left().getEl();
		if(par.right()!=null)
				childrenList[1]=par.right().getEl();
			
		
		return childrenList;
	}
	
	//method to return the number of children at position p
	public int numChildren(Position p){
		
		int counter=0;
		treeNode par=this.FindtreeNode(p);
		if(par.left()!=null){
			counter++;}
		if(par.right()!=null){
				counter++;
			}	
		
		return counter;
	
	}
	//method to return the position of the left child
	public Position Left(Position p){
		return this.FindtreeNode(p).left().getEl();
	}
	
	//method to return the position of the right child
	public Position Right(Position p){
		return this.FindtreeNode(p).right().getEl();
	}
	
	//method to return the position of the sibling of a position
	public Position Sibling(Position p){
		if(p.getID().equals(this.FindtreeNode(p).parent().right().getEl().getID()))
		return this.FindtreeNode(p).parent().left().getEl();
		else
			return this.FindtreeNode(p).parent().right().getEl();
	}
	
	//method to return boolean if the node is internal
	public Boolean isInternal(Position p){
		if (this.FindtreeNode(p).left()!=null||this.FindtreeNode(p).right()!=null)
			return true;
		else
			return false;
	}
	
	//method to check if a node at position p is external
	public Boolean isExternal(Position p){
		if(this.FindtreeNode(p).left()==null&&this.FindtreeNode(p).right()==null)
			return true;
		else 
			return false;
	}
	
	// method check if the position is root
	public Boolean isRoot(Position p){
		if(this.FindtreeNode(p).parent()==null)
			return true;
		else
			return false;
	}
		
	//size method to return the size of the tree, which the is number of node
	public int Size(){
		return nodeList.sizeList();
	}
	
	//method to check if the tree is empty
	public Boolean isEmpty(){
		if(this.head==null)
			return true;
		else
			return false;
	}
	
	//method to return the height of the tree
	public int heigh(){
		
		return AC(head,0);
		
	}
	
	private int AC(treeNode Root,int max){
		if(Root.left()==null&&Root.right()==null)
			return max;
		
		int max1 = 0 ;
		int max2 = 0 ;
		
			if(Root.left()!=null){
				 max1 = AC(Root.left(),max+1);
			}
			if(Root.right()!=null){
				 max2 = AC(Root.right(),max+1);
			}
			if(max1>max2){
				return max1;
			}
			else
				return max2;
			
	}
	
	//method to return the number of leafs 
	public int numLeaf(){
		return RP(this.head);
		
	}
	private int RP(treeNode p){
		if(p==null){
			return 0;
		}
		if(head.getEl()==null)
			return 0;
		else
		if(p.left()==null&&p.right()==null)
			return 1;
		else
			return RP(p.left()) + RP(p.right());
	}
	
	
	//method to clone a tree
	public Tree  Clone(){
		treeNode head2= new treeNode(); 
		head2.Clone(this.head);
		Tree newTree = new Tree(head2);
		ActualClone(this.head,head2);
		return newTree;
	}
	private void ActualClone(treeNode start, treeNode newtree){
		if(start.left()==null&&start.right()==null);
				
		else
			if(start.left()!=null){
				
				Position leftPosition =  new Position(start.left().getEl().getElement(),start.left().getEl().getID());
				treeNode newLeft = new treeNode(leftPosition);
				newtree.addLeftChild(newLeft);
				ActualClone(start.left(),newtree.left());
			}
			if(start.right()!=null){
				Position rightPosition =  new Position(start.right().getEl().getElement(),start.right().getEl().getID());
				treeNode newLeft = new treeNode(rightPosition);
				newtree.addRightChild(newLeft);
				ActualClone(start.right(),newtree.right());
			}
			
	}

	
	// method to return an array of all the positions in the tree
	 public Position[] Positions(){
		ArrayList<Position> list  = new ArrayList<Position>();
		list = this.nodeList.list;
		Position[] x ;
		x=(Position[])list.toArray();
		return x;
		}
	 	
	 //iterator class
	 public iterator iterator(){
		 
		return this.nodeList.iteratorObj;
		
		
	 }
	 
	 //methof to traverse the tree in inOrder way
	 public void inOrder(){
		 String str = "node";
		 int  x =this.Size();
		 this.actualInOrder(this.head,x);
		
		 
	 }
	 private static void actualInOrder(treeNode head,int x)
	 {
		 
		 
		 if(head==null);
			 
		 
		 else
		 {
			 	
				actualInOrder(head.left(),cc);
				
				 //setting up the position of each treeNode
				System.out.print(head.getEl().getElement() + " "); //printing the content of each
				
				head.getEl().setID("node" + cc++);
				
	 			actualInOrder(head.right(),x--);	
		 }
	 }
}