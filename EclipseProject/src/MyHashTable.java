public class MyHashTable {
	
	 private final static int NUMBUCKET = 13;
	 MyHashNode[] table;
	 
	 MyHashTable() {
		 table = new MyHashNode[NUMBUCKET];
		 for (int x = 0; x <table.length;x++) {
			 table[x] = null;
		 }	 
	 }
	 
	 public void insertion(String first, String last, 
				String email, String phone) {
		 
		 String firstAndLast = first.toUpperCase().concat(last.toUpperCase());
		 int hash = Math.abs((firstAndLast).hashCode());
		 
		 if(table[hash%table.length] == null) {
			 table[hash%table.length] = new MyHashNode(first, last, email, phone);			 
		 }
		 //Collision detection and resolution
		 else if (table[hash%table.length] != null){
			 if (table[0] == null) {
				 table[0] = new MyHashNode(first, last, email, phone);
			 }else if (table[((hash+1)%table.length)] == null) {
				 table[((hash+1)%table.length)] = new MyHashNode(first, last, email, phone);
			 }else if (table[((hash+2)%table.length)] == null) {
				 table[((hash+2)%table.length)] = new MyHashNode(first, last, email, phone);
			 }else if (table[((hash+3)%table.length)] == null) {
				 table[((hash+3)%table.length)] = new MyHashNode(first, last, email, phone);
			 }
		 }
	 }
	 
	 public void deletion(String first, String last) {
		 try {
			 MyHashNode nodeToDelete = lookup(first, last);
			 String firstAndLast = nodeToDelete.getFirstAndLast().toUpperCase();
			 int hash = Math.abs(firstAndLast.hashCode());
			 
			 if (table[hash%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 table[hash%table.length] = null;
				 System.out.println("and the Deletion was successful for " + firstAndLast);
			 }else if (table[(hash+1)%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 table[(hash+1)%table.length] = null;
				 System.out.println("and the Deletion was successful for " + firstAndLast);
			 }else if (table[(hash+2)%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 table[(hash+2)%table.length] = null;
				 System.out.println("and the Deletion was successful for " + firstAndLast);
			 }else if (table[(hash+3)%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 table[(hash+3)%table.length] = null;
				 System.out.println("and the Deletion was successful for " + firstAndLast);
			 }
		 }catch (NullPointerException e) {
			 System.out.println("Deletion UNSUCCESSFUL for " + first.concat(last).toUpperCase());
		 }
	 }
	 
	 public MyHashNode lookup(String first, String last) {
		 String firstAndLast = first.toUpperCase().concat(last.toUpperCase());
		 int hash = Math.abs((firstAndLast).hashCode());
		 
		 try {
			 if(table[hash%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 System.out.println("Lookup successful for " + table[hash%table.length].getFirstAndLast().toUpperCase());
				 return table[hash%table.length];
			 }else if (table[(hash+1)%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 System.out.println("Lookup successful for " + table[(hash+1)%table.length].getFirstAndLast().toUpperCase());
				 return table[(hash+1)%table.length];
			 }else if (table[(hash+2)%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 System.out.println("Lookup successful for " + table[(hash+2)%table.length].getFirstAndLast().toUpperCase());
				 return table[(hash+2)%table.length];
			 }else if (table[(hash+3)%table.length].getFirstAndLast().toUpperCase().compareTo(firstAndLast) == 0 ) {
				 System.out.println("Lookup successful for " + table[(hash+3)%table.length].getFirstAndLast().toUpperCase());
				 return table[(hash+3)%table.length];
			 }else {
				 return null;
			 }
		 }catch (NullPointerException e) {
			 System.out.println("Lookup UNSUCCESSFUL for "+firstAndLast);
		 }
		 return null;
	 }
	 
	 public void printAll() {
 		 for (MyHashNode x : table){
 			 if(x != null) {
 				 System.out.println(x.getFirstName());
	 			 }
	 		 }
 	 } 
}