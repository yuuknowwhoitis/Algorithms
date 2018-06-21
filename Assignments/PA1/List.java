class List{

   private class Node{
      // Fields
      int data;
      Node next;
      
      // Constructor
      Node(int data) { this.data = data; next = null; }
      
      // toString():  overrides Object's toString() method
      public String toString() { 
         return String.valueOf(data); 
      }
      
      // equals(): overrides Object's equals() method
      public boolean equals(Object x){
         boolean eq = false;
         Node that;
         if(x instanceof Node){
            that = (Node) x;
            eq = (this.data==that.data);
         }
         return eq;
      }
   }

   // Fields
   private Node front;
   private Node back;
   private int length;
   Node curr;

   // Constructor
   List() { 
      front = back = null; 
      length = 0; 
      cursor = null;
   }


   // Access Functions --------------------------------------------------------

   // isEmpty()
   // Returns true if this Queue is empty, false otherwise.
   boolean isEmpty() { 
      return length==0; 
   }

   // getLength()
   // Returns length of this Queue.
   int length() { 
      return length; 
   }

   // index()
   // If cursor is defined, return the index of the cursor element
   // otherwise return -1 
   int index(){
      int n = length;
      while(cursor != null){
         n--;
         cursor = cursor.next;
      }
      return n;
   }

   // front() 
   // Returns front element.
   // Pre: !this.isEmpty()
   int front(){
      if( this.isEmpty() ){
         throw new RuntimeException(
            "Queue Error: front() called on empty Queue");
      }
      return front.data;
   }

   // back()
   // Returns back element.
   // Pre: !this.isEmpty()
   int back(){
      if(this.isEmpty()){
         throw new RuntimeException(
            "Queue Error: back() called on empty Queue")
      }
      else{
         return back.data;
      }
   }


   // equals(List L)
   // Returns true if and only if List and L are the same
   // integer sequence. The states of the cursors in the two Lists
   // are not used in determining equality
   boolean equals(List L){
      boolean eq = false;
      Node X,Y;

      X = this.front;
      Y = L.front;
      eq = (this.length == L.length);
      while( eq && Y!null){
         eq = (X.data == Y.data);
         X = X.next;
         Y = Y.next;
      }
      return eq;
   }

   

   // Manipulation Procedures -------------------------------------------------

   // clear()
   // Resets this list to its original empty state
   void clear(){
      front = back = null; 
      length = 0; 
      cursor = null;
   }

   // moveFront()
   // If list is non-empty, places the cursor under the front element
   // otherwise does nothing
   void moveFront(){
      if(!this.isEmpty()){
         cursor = front;
      }
   }

   // moveBack()
   // If list is non-empty, places the cursor under the back element
   // otherwise does nothing
   void moveBack(){
      if(!this.isEmpty()){
         cursor = back;
      }
   }

   // movePrev()
   // If cursor is defined and not at front, moves cursor one step toward
   // front of this List, if cursor is defined and at front, cursor becomes
   // undefined, if cursor is undefined does nothing.
   void movePrev(){
      if((cursor != null) && (cursor != front)){
         Node curr = front;
         while(curr.next != cursor){
            curr = curr.next;
         }
         cursor = curr;
      }
      else if((cursor != null) && (cursor == front)){
         cursor = null;
      }
      else if(cursor == null){

      }
   }


   // moveNext()
   // If cursor is defined and not at back, moves cursor one step toward
   // back of this List, if cursor is defined and at back, cursor becomes
   // undefined, if cursor is undefined does nothing.
   void moveNext(){
      if((cursor != null) && (cursor != back)){
         cursor = cursor.next;
      }
      else if((cursor != null) && (cursor == back)){
         cursor = null;
      }
      else if(cursor == null){
         
      }
   }

   // prepend(int data)
   // Insert new element into this List. If List is non-empty,
   // insertion takes place before front element.
   void prepend(int data){
      Node curr = new Node(data);
      curr.next = front;
      front = curr;
   }

   // append(int data)
   // Insert new element into this List. If List is non-empty,
   // insertion takes place after back element.
   void append(int data){
      Node curr = new Node(data);
      back.next = curr;
      back = curr;
   }

   // insertBefore(int data)
   // Insert new element before cursor.
   // Pre: length()>0, index()>=0

   void insertBefore(int data){
      if(this.length() > 0 && this.index() >= 0){
         Node curr = front;
         for(int i = 0; i < this.index - 1; i++){
            curr = curr.next;
         }
         Node x = new Node(data);
         x.next = curr.next;
         curr.next = x;
      }
   }

   // insertAfter(int data)
   // Insert new element after cursor.
   // Pre: length()>0, index()>=0

   void insertAfter(int data){
      if(this.length() > 0 && this.index() >= 0){
         Node curr = front;
         for(int i = 0; i < this.index; i++){
            curr = curr.next;
         }
         Node x = new Node(data);
         x.next = curr.next;
         curr.next = x;
      }
   }

   // deleteFront()
   // Deletes the front element. Pre: length()>0

   void deleteFront(){
      if(this.length() > 0){  
         front = front.next;
      }
   }

   // deleteBack()
   // Deletes the back element. Pre: length()>0

   void deleteBack(){
      if(this.length() > 0){  
         Node curr = front;
         for(int i = 0; i < this.length() - 2; i++){
            curr = curr.next;
         }
         back.next = null;
         back = curr;
      }
   }

   // delete()
   // Deletes cursor element, making cursor undefined.
   // Pre: length()>0, index()>=0
   void delete(){
      if(this.length() > 0 && this.index() >= 0){
         Node curr = front;
         for(int i = 0; i < this.index() - 1; i++){
            curr = curr.next;
         }
         curr.next = cursor.next;
         cursor = null;
      }
   }

   


   // Other Functions ---------------------------------------------------------

   // toString()
   // Overides Object's toString() method.
   public String toString(){
      String s = "";
      Node curr = front;
      for(int i = 0; i < this.length; i++){
         String num = Integer.toString(curr.data);
         s += num;
         s += " ";
      }
   }

   

   // copy()
   // Returns a new Queue identical to this Queue.
   Queue copy(){
      Queue Q = new Queue();
      Node N = this.front;

      while( N!=null ){
         Q.Enqueue(N.data);
         N = N.next;
      }
      return Q;
   }

}